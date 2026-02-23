/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.console;

import com.example.factory.model.CalculationResult;
import com.example.factory.ui.Output;

/**
 *
 * @author sangr
 */
public class ConsoleOutputRenderer implements Output {
    @Override
    public void render(CalculationResult result) {
        System.out.println("Operación : " + result.operationName());
        System.out.println("Resultado : " + result.value());
    }
}
