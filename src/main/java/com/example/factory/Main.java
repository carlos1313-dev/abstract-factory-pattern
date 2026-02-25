/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.factory;

import com.example.factory.model.CalculationResult;
import com.example.factory.operations.Operation;
import com.example.factory.operations.OperationFactory;
import com.example.factory.ui.Input;
import com.example.factory.ui.Output;
import com.example.factory.ui.UIFactory;
import com.example.factory.ui.console.ConsoleUIFactory;
import com.example.factory.ui.swing.SwingUIFactory;
import java.util.Scanner;
import org.springframework.boot.SpringApplication;

import javax.swing.SwingUtilities;

/**
 *
 * @author sangr
 */

public class Main {

    public static void main(String[] args) {

        String mode;
        if (args.length > 0) {
            mode = args[0];
        } else {
            try (Scanner scanner = new Scanner(System.in)) {
                System.out.println("Elige el modo de ejecución:");
                System.out.println("  1. console");
                System.out.println("  2. swing"); //
                System.out.println("  3. web");
                System.out.print("Modo: ");
                mode = scanner.nextLine().trim().toLowerCase();
            }
        }
        
        

        
        if (mode.equals("web")) {
            System.out.println("Modo web activo. Accede a http://localhost:8080/index.html");
            SpringApplication.run(FactoryApplication.class, args); 
            return;
            
        }

        // Abstract Factory — solo para consola y swing
        UIFactory factory = switch (mode) {
            
/*<<<<<<< HEAD
            case "swing" -> new SwingUIFactory();
            default      -> new ConsoleUIFactory();
        };

        Input  input  = factory.createInputHandler();
=======*/
            case "swing" ->
                new SwingUIFactory();
            //case "web"   -> new WebUIFactory(0, 0, ""); // Spring toma el control real
            case "console" ->
                new ConsoleUIFactory();
            default ->
            	throw new IllegalArgumentException("Modo inválido");
        };

        // Si el modo es web, Spring Boot se encarga del resto
        // El controller instancia su propia WebUIFactory con los datos del request
        
        /*
        if (mode.equals("web")) {
            System.out.println("Modo web activo. Accede a http://localhost:8080");
            // Aquí arrancaría Spring: SpringApplication.run(App.class, args);
            return;
            
        */
            
            
        

        // 3. Crear los componentes — Main solo habla con interfaces
        Input input = factory.createInputHandler();
//>>>>>>> origin/dev-nicolas/fixUI
        Output output = factory.createOutputRenderer();

        String   opType   = input.getOperationType();
        double[] operands = input.getOperands();

        Operation operation = OperationFactory.create(opType);
        double result = operation.execute(operands[0], operands[1]);

        output.render(new CalculationResult(operation.getName(), result));
    }
}


