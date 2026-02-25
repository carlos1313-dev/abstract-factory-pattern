/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.web;

import com.example.factory.model.CalculationResult;
import com.example.factory.ui.Output;

/**
 *
 * @author sangr
 */
public class WebOutputRenderer implements Output {

    private CalculationResult lastResult;

    @Override
    public void render(CalculationResult result) {
        this.lastResult = result;
    }

    public CalculationResult getLastResult() {
        return lastResult;
    }
}
