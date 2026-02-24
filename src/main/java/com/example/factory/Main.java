/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory;

import com.example.factory.exception.UserCancelledException;
import com.example.factory.model.CalculationResult;
import com.example.factory.operations.Operation;
import com.example.factory.operations.OperationFactory;
import com.example.factory.ui.Input;
import com.example.factory.ui.Output;
import com.example.factory.ui.UIFactory;
import com.example.factory.ui.console.ConsoleUIFactory;
import com.example.factory.ui.swing.SwingUIFactory;
import java.util.Scanner;

/**
 *
 * @author sangr
 */
import javax.swing.SwingUtilities;
import java.util.Scanner;
import javax.swing.JOptionPane;

import javax.swing.SwingUtilities;
import java.awt.GraphicsEnvironment;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // 1. Detectar el modo desde argumentos
        //    java -jar calculadora.jar swing
        String mode = (args.length > 0)
                ? args[0].trim().toLowerCase()
                : "console"; // modo por defecto

        // 2. Arranque según el modo
        if ("swing".equals(mode)) {

            // Swing siempre en el EDT
            SwingUtilities.invokeLater(() ->
                runWithFactory(new SwingUIFactory())
            );

        } else if ("web".equals(mode)) {

            System.out.println("Modo web activo");
            // SpringApplication.run(App.class, args);

        } else {

            // Consola (default)
            runWithFactory(new ConsoleUIFactory());
        }
    }

    // Lógica común independiente de la UI
    private static void runWithFactory(UIFactory factory) {
        try {
            Input input = factory.createInputHandler();
            Output output = factory.createOutputRenderer();

            String operationType = input.getOperationType();
            double[] operands = input.getOperands();

            Operation operation = OperationFactory.create(operationType);
            if (operation == null) {
                throw new IllegalArgumentException("Operación no soportada");
            }

            double result = operation.execute(operands[0], operands[1]);

            output.render(
                new CalculationResult(operation.getName(), result)
            );

        } catch (UserCancelledException e) {
            System.out.println("Operación cancelada por el usuario");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}