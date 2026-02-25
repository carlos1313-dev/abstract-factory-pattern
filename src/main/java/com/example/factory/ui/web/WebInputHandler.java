package com.example.factory.ui.web;

import com.example.factory.adapter.input.InputAdapter;
import com.example.factory.adapter.input.IntegerToDoubleAdapter;
import com.example.factory.adapter.input.StringToDoubleAdapter;
import com.example.factory.ui.Input;

/**
 * Web input handler.
 * The HTTP request arrives as a raw String (e.g. "3.5,2").
 * Adapters convert it to double[] — same shared adapters used by Console and Swing.
 *
 * inputMode "string"  → StringToDoubleAdapter  (e.g. "3.5,2")
 * inputMode "integer" → IntegerToDoubleAdapter  (e.g. "4,7" parsed as ints first)
 */
public class WebInputHandler implements Input {

    private final String rawInput;
    private final String inputMode;   // "string" | "integer"
    private final String operationType;

    // Shared adapters — same ones used by Console and Swing
    private final InputAdapter<String> stringAdapter = new StringToDoubleAdapter();
    private final InputAdapter<int[]>  intAdapter    = new IntegerToDoubleAdapter();

    public WebInputHandler(String rawInput, String inputMode, String operationType) {
        this.rawInput      = rawInput;
        this.inputMode     = inputMode;
        this.operationType = operationType;
    }

    @Override
    public double[] getOperands() {
        if ("integer".equalsIgnoreCase(inputMode)) {
            // Parse as ints first, then adapt to double[]
            String[] parts = rawInput.split(",");
            if (parts.length != 2)
                throw new IllegalArgumentException("Se esperaban dos enteros separados por coma.");
            int[] ints = {
                Integer.parseInt(parts[0].trim()),
                Integer.parseInt(parts[1].trim())
            };
            return intAdapter.adapt(ints);
        }
        // Default: StringToDoubleAdapter
        return stringAdapter.adapt(rawInput);
    }

    @Override
    public String getOperationType() {
        return operationType;
    }
}
