/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.operations;

/**
 *
 * @author sangr
 */
public class OperationFactory {
    public static Operation create(String type) {
        return switch (type.toLowerCase()) {
            case "add"      -> new AddOperation();
            case "subtract" -> new SubtractOperation();
            default -> throw new IllegalArgumentException("Operación desconocida: " + type);
        };
    }
}