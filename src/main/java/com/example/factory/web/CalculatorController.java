/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.web;

import com.example.factory.model.CalculationResult;
import com.example.factory.operations.Operation;
import com.example.factory.operations.OperationFactory;
import com.example.factory.ui.Input;
import com.example.factory.ui.web.WebOutputRenderer;
import com.example.factory.ui.web.WebUIFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Spring controller.
 *
 * Before: received (double a, double b) — Spring auto converted, bypassing adapters.
 * After:  receives (String operands, String inputMode)  raw data, adapters do the work.
 *
 * Form fields expected:
 *   operands  : "3.5,2"   (two numbers separated by comma)
 *   inputMode : "string" / "integer"   (default: "string")
 *   operation : add / subtract / multiplication / division
 */
@Controller
@CrossOrigin(origins = "*")
public class CalculatorController {

    @GetMapping("/")
    public String index() {
        return "redirect:/static/index.html";
    }

    @PostMapping("/calculate")
    @ResponseBody
    public String calculate(
            @RequestParam String operands,
            @RequestParam(defaultValue = "string") String inputMode,
            @RequestParam String operation) {

        // 1. Abstract Factory creates the Web family
        //    Passes raw strings — adapters run inside WebInputHandler
        WebUIFactory factory = new WebUIFactory(operands, inputMode, operation);

        // 2. Get components — same flow as Console/Swing Main.java
        Input             input  = factory.createInputHandler();
        WebOutputRenderer output = (WebOutputRenderer) factory.createOutputRenderer();

        // 3. Factory Method creates the operation
        Operation op = OperationFactory.create(input.getOperationType());

        // 4. Execute — getOperands() triggers the adapter internally
        double[] nums   = input.getOperands();
        double   result = op.execute(nums[0], nums[1]);

        // 5. Render - stores result internally
        output.render(new CalculationResult(op.getName(), result));

        // 6. Build HTML response using output adapters
        String formatted = output.getFormattedString();  // ResultToStringAdapter
        int    truncated = output.getTruncatedInt();      // ResultToIntAdapter

        return """
                <div class="result">
                    <span class="label">%s</span>
                    <span class="value">%s</span>
                    <span class="value-int">Valor entero: %d</span>
                </div>
               """.formatted(
                    output.getLastResult().operationName(),
                    output.getLastResult().value(),
                    truncated
               );
    }
}