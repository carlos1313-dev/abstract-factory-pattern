/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.swing;


import com.example.factory.adapter.input.InputAdapter;
import com.example.factory.adapter.input.StringToDoubleAdapter;
import com.example.factory.adapter.input.IntegerToDoubleAdapter;
import com.example.factory.ui.Input;
import javax.swing.JOptionPane;

/**
 * @author dev.nicolasrin & sangr
 * Swing input handler.
 * Uses the SAME shared adapters as ConsoleInputHandler —
 * the adapters are environment agnostic (they only convert data types).
 */
public class SwingInputHandler implements Input {

    // Shared adapters — same ones used by ConsoleInputHandler
    private final InputAdapter<String> stringAdapter = new StringToDoubleAdapter();
    private final InputAdapter<int[]>  intAdapter    = new IntegerToDoubleAdapter();

    @Override
    public double[] getOperands() {
        String[] options = {"Texto (ej: 3.5,2)", "Enteros (ej: 4 y 7)"};
        int choice = JOptionPane.showOptionDialog(
            null,
            "¿Cómo deseas ingresar los operandos?",
            "Tipo de entrada",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null, options, options[0]
        );

        if (choice == 1) {
            // IntegerToDoubleAdapter
            String a = JOptionPane.showInputDialog("Primer entero:");
            String b = JOptionPane.showInputDialog("Segundo entero:");
            if (a == null || b == null)
                throw new IllegalStateException("Operación cancelada por el usuario.");
            return intAdapter.adapt(new int[]{
                Integer.parseInt(a.trim()),
                Integer.parseInt(b.trim())
            });
        } else {
            // StringToDoubleAdapter (default)
            String raw = JOptionPane.showInputDialog("Ingresa los operandos separados por coma (ej: 3.5,2):");
            if (raw == null)
                throw new IllegalStateException("Operación cancelada por el usuario.");
            return stringAdapter.adapt(raw.trim());
        }
    }

    @Override
    public String getOperationType() {
        String[] ops = {"add", "subtract", "multiplication", "division"};
        String op = (String) JOptionPane.showInputDialog(
            null,
            "Selecciona la operación:",
            "Operación",
            JOptionPane.QUESTION_MESSAGE,
            null, ops, ops[0]
        );
        if (op == null)
            throw new IllegalStateException("Operación cancelada por el usuario.");
        return op;
    }
}