/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.adapter;

import com.example.factory.legacy.LegacyCalculator;
import com.example.factory.operations.Operation;

/**
 *
 * @author sangr
 * Se utiliza el patrón adapter para el ejemplo, pues utiliza la calculadora (legacy) que trabaja con ints, y genera un
 * camino entre lo que necesita el proyecto y la calculadora, adaptando los tipos
 */
public class LegacyCalculatorAdapter implements Operation {
    private final LegacyCalculator legacy = new LegacyCalculator();

    @Override
    public double execute(double a, double b) {
        return legacy.computeSum((int) a, (int) b); // adapta tipos y firma
    }

    @Override public String getName() { return "Suma (legacy)"; }
}
