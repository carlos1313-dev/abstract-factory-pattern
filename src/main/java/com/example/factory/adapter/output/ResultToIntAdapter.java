package com.example.factory.adapter.output;

import com.example.factory.model.CalculationResult;

/**
 * Adapter: converts the result value from double to int (truncates decimals).
 * Useful when the consumer only needs integer output.
 * Example: result.value() = 8.9 → returns 8
 */
public class ResultToIntAdapter implements OutputAdapter<Integer> {

    @Override
    public Integer adapt(CalculationResult result) {
        return (int) result.value();
    }
}
