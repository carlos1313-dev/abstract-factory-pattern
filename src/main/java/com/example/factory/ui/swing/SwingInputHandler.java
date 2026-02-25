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
    	
    	String a = JOptionPane.showInputDialog("Primer número:");
    	String b = JOptionPane.showInputDialog("Segundo número:");
    	
        if (a == null || b == null) {
            throw new IllegalStateException("Operación cancelada por el usuario.");
        }
        return new double[]{Double.parseDouble(a), Double.parseDouble(b)};
    }

    @Override
    public String getOperationType() {
        return JOptionPane.showInputDialog("Operación (add / subtract / division / multiplication):");
    }
}
