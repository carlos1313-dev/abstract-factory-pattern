package com.example.factory.adapter.input;

/**
 * @author dev.nicolasrin
 * Adapter: converts a String like "3.5,2.0" into double[]{3.5, 2.0}
 * Example input: "3.5,2" → double[]{3.5, 2.0}
 */
public class StringToDoubleAdapter implements InputAdapter<String> {

    @Override
    public double[] adapt(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("El valor no puede estar vacío.");
        }
        String[] parts = value.split(",");
        if (parts.length != 2) {
            throw new IllegalArgumentException(
                "Se esperaban dos números separados por coma. Ej: \"3.5,2\"");
        }
        return new double[]{
            Double.parseDouble(parts[0].trim()),
            Double.parseDouble(parts[1].trim())
        };
    }
}
