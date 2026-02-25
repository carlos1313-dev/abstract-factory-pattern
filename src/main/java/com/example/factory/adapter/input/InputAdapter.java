package com.example.factory.adapter.input;

/**
 * @author dev.nicolasrin
 * Adapter interface for converting any type T into double[]
 * so it can be used by the Input handlers.
 */
public interface InputAdapter<T> {
    double[] adapt(T value);
}
