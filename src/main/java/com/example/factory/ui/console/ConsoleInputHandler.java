/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.ui.console;

import com.example.factory.ui.Input;
import java.util.Scanner;

/**
 *
 * @author sangr
 */
public class ConsoleInputHandler implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public double[] getOperands() {
        System.out.print("Ingresa el primer número: ");
        double a = scanner.nextDouble();
        System.out.print("Ingresa el segundo número: ");
        double b = scanner.nextDouble();
        return new double[]{a, b};
    }

    @Override
    public String getOperationType() {
        System.out.print("Operación (add / subtract): ");
        return scanner.next();
    }
}