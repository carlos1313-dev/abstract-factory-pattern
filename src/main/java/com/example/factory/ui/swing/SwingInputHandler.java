/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.swing;

import com.example.factory.ui.Input;
import javax.swing.JOptionPane;

/**
 *
 * @author sangr
 */
public class SwingInputHandler implements Input {
    @Override
    public double[] getOperands() {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Primer número:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Segundo número:"));
        return new double[]{a, b};
    }

    @Override
    public String getOperationType() {
        return JOptionPane.showInputDialog("Operación (add / subtract):");
    }
}
