/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.swing;

import com.example.factory.ui.Input;
import com.example.factory.ui.Output;
import com.example.factory.ui.UIFactory;

/**
 *
 * @author sangr
 */
public class SwingUIFactory implements UIFactory {
    @Override public Input createInputHandler()    { return new SwingInputHandler(); }
    @Override public Output createOutputRenderer() { return new SwingOutputRenderer(); }
}