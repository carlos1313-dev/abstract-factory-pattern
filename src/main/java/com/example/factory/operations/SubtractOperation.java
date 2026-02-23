/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.operations;

/**
 *
 * @author sangr
 */
public class SubtractOperation implements Operation {
    @Override public double execute(double a, double b) { return a - b; }
    @Override public String getName() { return "Resta"; }
}
