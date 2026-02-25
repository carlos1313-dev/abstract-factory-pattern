package com.example.factory.adapter.input;

/**
 * @author dev.nicolasrin
 * Adapter: converts an int[] {3, 5} into double[]{3.0, 5.0}
 * This lets the calculator receive integer operands and work with them as doubles.
 */
public class IntegerToDoubleAdapter implements InputAdapter<int[]> {

    @Override
    public double[] adapt(int[] value) {
        if (value == null || value.length != 2) {
            throw new IllegalArgumentException(
                "Se esperaba un arreglo de exactamente 2 enteros.");
        }
        return new double[]{value[0], value[1]};
    }
}
