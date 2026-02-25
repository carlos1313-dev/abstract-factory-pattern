/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.web;

import com.example.factory.ui.Input;
import com.example.factory.ui.Output;
import com.example.factory.ui.UIFactory;

/**
 * @author dev.nicolasrin & sangr
 * Web Abstract Factory.
 * Now receives raw String input so the adapters inside WebInputHandler
 * do the type conversion — consistent with Console and Swing factories.
 */
public class WebUIFactory implements UIFactory {

    private final String rawInput;     // e.g. "3.5,2"
    private final String inputMode;    // "string" | "integer"
    private final String operationType;

    public WebUIFactory(String rawInput, String inputMode, String operationType) {
        this.rawInput      = rawInput;
        this.inputMode     = inputMode;
        this.operationType = operationType;
    }

    @Override
    public Input createInputHandler() {
        return new WebInputHandler(rawInput, inputMode, operationType);
    }

    @Override
    public Output createOutputRenderer() {
        return new WebOutputRenderer();
    }
}
