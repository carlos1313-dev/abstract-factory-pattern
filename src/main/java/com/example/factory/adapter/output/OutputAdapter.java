package com.example.factory.adapter.output;

import com.example.factory.model.CalculationResult;

/**
 * Adapter interface for converting a CalculationResult into another type T.
 * Useful when the output format needs to differ from the default render.
 */
public interface OutputAdapter<T> {
    T adapt(CalculationResult result);
}
