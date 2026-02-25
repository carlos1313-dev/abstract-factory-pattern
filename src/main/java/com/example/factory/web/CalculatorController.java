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
 *
 * @author sangr
 */
// web/CalculatorController.java
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
            @RequestParam double a,
            @RequestParam double b,
            @RequestParam String operation) {

        // 1. Abstract Factory crea la familia Web
        WebUIFactory factory = new WebUIFactory(a, b, operation);

        // 2. Obtener componentes — igual que en Main.java
        Input input         = factory.createInputHandler();
        WebOutputRenderer output   = (WebOutputRenderer) factory.createOutputRenderer();

        // 3. Factory Method crea la operación
        Operation op = OperationFactory.create(input.getOperationType());

        // 4. Ejecutar
        double[] operands = input.getOperands();
        double result     = op.execute(operands[0], operands[1]);

        // 5. Renderizar (guarda internamente el resultado)
        output.render(new CalculationResult(op.getName(), result));

        // 6. Devolver HTML al navegador
        CalculationResult cr = output.getLastResult();
        return """
                <div class="result">
                    <span class="label">%s</span>
                    <span class="value">%s</span>
                </div>
               """.formatted(cr.operationName(), cr.value());
    }
}