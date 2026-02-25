/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.console;

import com.example.factory.adapter.input.InputAdapter;
import com.example.factory.adapter.input.StringToDoubleAdapter;
import com.example.factory.adapter.input.IntegerToDoubleAdapter;
import com.example.factory.ui.Input;
import java.util.Scanner;

/**
 * @author dev.nicolasrin & sangr
 * Console input handler.
 * Uses adapters to convert user input (String) into double[],
 * and also demonstrates integer input via IntegerToDoubleAdapter.
 */
public class ConsoleInputHandler implements Input {

    private final Scanner scanner = new Scanner(System.in);

    // Adapter: String "a,b" → double[]
    private final InputAdapter<String> stringAdapter = new StringToDoubleAdapter();

    // Adapter: int[] → double[] (demo: could come from another system)
    private final InputAdapter<int[]> intAdapter = new IntegerToDoubleAdapter();

    @Override
    public double[] getOperands() {
        System.out.println("¿Cómo deseas ingresar los operandos?");
        System.out.println("  1 - Como texto  (ej: 3.5,2)");
        System.out.println("  2 - Como enteros (ej: 4 y 7)");
        System.out.print("Opción: ");
        String option = scanner.nextLine().trim();

        if ("2".equals(option)) {
            // Use IntegerToDoubleAdapter
            System.out.print("Primer entero: ");
            int a = scanner.nextInt();
            System.out.print("Segundo entero: ");
            int b = scanner.nextInt();
            return intAdapter.adapt(new int[]{a, b});
        } else {
            // Default: Use StringToDoubleAdapter
            System.out.print("Ingresa los operandos separados por coma (ej: 3.5,2): ");
            String raw = scanner.nextLine().trim();
            return stringAdapter.adapt(raw);
        }
    }

    @Override
    public String getOperationType() {
        System.out.print("Operación (add / subtract / multiplication / division): ");
        return scanner.nextLine().trim();
    }
}