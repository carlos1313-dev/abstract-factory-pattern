/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.console;

import com.example.factory.ui.Input;
import com.example.factory.ui.Output;
import com.example.factory.ui.UIFactory;

/**
 *
 * @author sangr
 */
public class ConsoleUIFactory implements UIFactory {
    @Override public Input createInputHandler()   { return new ConsoleInputHandler(); }
    @Override public Output createOutputRenderer() { return new ConsoleOutputRenderer(); }
}
