/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.console;

import com.example.factory.adapter.output.OutputAdapter;
import com.example.factory.adapter.output.ResultToStringAdapter;
import com.example.factory.adapter.output.ResultToIntAdapter;
import com.example.factory.model.CalculationResult;
import com.example.factory.ui.Output;

/**
 * Console output renderer.
 * Demonstrates use of output adapters to render the result
 * in different formats: as a formatted String or as an integer.
 */
public class ConsoleOutputRenderer implements Output {

    private final OutputAdapter<String> stringAdapter = new ResultToStringAdapter();
    private final OutputAdapter<Integer> intAdapter   = new ResultToIntAdapter();

    @Override
    public void render(CalculationResult result) {
        // Default string format via adapter
        System.out.println("=== Resultado (String adapter) ===");
        System.out.println(stringAdapter.adapt(result));

        // Integer format via adapter (truncates decimals)
        System.out.println("=== Resultado (Integer adapter) ===");
        System.out.println("Valor entero: " + intAdapter.adapt(result));
    }
}
