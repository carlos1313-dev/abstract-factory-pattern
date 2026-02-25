package com.example.factory.adapter.output;

import com.example.factory.model.CalculationResult;

/**
 * Adapter: converts a CalculationResult into a formatted String.
 * Example output: "ADD: 8.0"
 */
public class ResultToStringAdapter implements OutputAdapter<String> {

    @Override
    public String adapt(CalculationResult result) {
        return result.operationName().toUpperCase() + ": " + result.value();
    }
}
