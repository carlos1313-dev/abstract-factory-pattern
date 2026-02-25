package com.example.factory.operations;

public class MultiplicationOperation implements Operation {
    @Override public double execute(double a, double b) { return a * b; }
    @Override public String getName() { return "Multiplicación"; }
}
