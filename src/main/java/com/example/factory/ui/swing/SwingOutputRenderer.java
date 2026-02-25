/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.swing;

import com.example.factory.adapter.output.OutputAdapter;
import com.example.factory.adapter.output.ResultToStringAdapter;
import com.example.factory.adapter.output.ResultToIntAdapter;
import com.example.factory.model.CalculationResult;
import com.example.factory.ui.Output;
import javax.swing.JOptionPane;

/**
 * @author dev.nicolasrin & sangr
 * Swing output renderer.
 * Uses the SAME shared output adapters as ConsoleOutputRenderer.
 * Demonstrates both String and Integer output formats via dialog.
 */
public class SwingOutputRenderer implements Output {

    // Shared adapters — same ones used by ConsoleOutputRenderer
    private final OutputAdapter<String>  stringAdapter = new ResultToStringAdapter();
    private final OutputAdapter<Integer> intAdapter    = new ResultToIntAdapter();

    @Override
    public void render(CalculationResult result) {
        // String adapter > formatted message
        String formatted = stringAdapter.adapt(result);

        // Integer adapter > truncated value
        int truncated = intAdapter.adapt(result);

        JOptionPane.showMessageDialog(
            null,
            "Resultado (String adapter): " + formatted + "\n" +
            "Resultado (Integer adapter): " + truncated,
            "Resultado",
            JOptionPane.INFORMATION_MESSAGE
        );
    }
}