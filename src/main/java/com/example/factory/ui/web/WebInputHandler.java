/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.web;

import com.example.factory.ui.Input;

/**
 *
 * @author sangr
 */
public class WebInputHandler implements Input {

    private final double a;
    private final double b;
    private final String operationType;

    public WebInputHandler(double a, double b, String operationType) {
        this.a = a;
        this.b = b;
        this.operationType = operationType;
    }

    @Override
    public double[] getOperands() {
        return new double[]{a, b};
    }

    @Override
    public String getOperationType() {
        return operationType;
    }
}
