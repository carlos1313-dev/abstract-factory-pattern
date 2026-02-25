/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.web;

import com.example.factory.ui.Input;
import com.example.factory.ui.Output;
import com.example.factory.ui.UIFactory;

/**
 *
 * @author sangr
 */
// ui/web/WebUIFactory.java
public class WebUIFactory implements UIFactory {

    private final double a;
    private final double b;
    private final String operationType;

    public WebUIFactory(double a, double b, String operationType) {
        this.a = a;
        this.b = b;
        this.operationType = operationType;
    }

    @Override
    public Input createInputHandler() {
        return new WebInputHandler(a, b, operationType);
    }

    @Override
    public Output createOutputRenderer() {
        return new WebOutputRenderer();
    }
}
