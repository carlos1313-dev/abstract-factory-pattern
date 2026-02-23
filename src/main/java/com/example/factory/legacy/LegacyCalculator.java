/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory.legacy;

/**
 *
 * @author sangr
 * Esta es una clase que simula una librería "Legacy", porque este concepto se refiere a una librería o implementación de código bien sea
 * antiguo o que no se puede modificar, para lo cual se usa el patrón adapter. En este caso, es una suma ineficiente para el proyecto,
 * porque usa sólo int, mientras que el proyecto actual usa double.
 */
public class LegacyCalculator {
    public int computeSum(int a, int b) { return a + b; }
}