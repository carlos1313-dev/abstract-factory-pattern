/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.swing;

import com.example.factory.model.CalculationResult;
import com.example.factory.ui.Output;
import javax.swing.JOptionPane;

/**
 *
 * @author sangr
 */
public class SwingOutputRenderer implements Output {
    @Override
    public void render(CalculationResult result) {
        JOptionPane.showMessageDialog(null,
            result.operationName() + " = " + result.value());
    }
}