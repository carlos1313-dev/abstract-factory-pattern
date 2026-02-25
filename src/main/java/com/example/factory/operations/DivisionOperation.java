package com.example.factory.operations;

public class DivisionOperation implements Operation {
    @Override public double execute(double a, double b) { 
    	if(b==0) {
    		throw new ArithmeticException("no se puede dividir por 0");
    		}else {
    			return a / b; 
    		}
    	}
    @Override public String getName() { return "División"; }
}

