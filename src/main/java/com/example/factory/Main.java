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

/**
 *
 * @author sangr
 */

public class Main {

    public static void main(String[] args) {

        // 1. El usuario elige el modo al ejecutar el programa
        //    Ejemplo: java Main console
        //             java Main swing
        //             java Main web  (Spring toma el control desde aquí)
        // Preguntar el modo si no viene como argumento
        String mode;
        if (args.length > 0) {
            mode = args[0];
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Elige el modo de ejecución:");
            System.out.println("  1. console");
            System.out.println("  2. swing");
            System.out.print("Modo: ");
            mode = scanner.nextLine().trim().toLowerCase();
        }

        // 2. Abstract Factory — elige la familia completa de UI
        UIFactory factory = switch (mode) {
            case "swing" ->
                new SwingUIFactory();
            //case "web"   -> new WebUIFactory(0, 0, ""); // Spring toma el control real
            default ->
                new ConsoleUIFactory();
        };

        // Si el modo es web, Spring Boot se encarga del resto
        // El controller instancia su propia WebUIFactory con los datos del request
        if (mode.equals("web")) {
            System.out.println("Modo web activo. Accede a http://localhost:8080");
            SpringApplication.run(Main.class, args);
            return;
        }

        // 3. Crear los componentes — Main solo habla con interfaces
        Input input = factory.createInputHandler();
        Output output = factory.createOutputRenderer();

        // 4. Pedir datos al usuario (consola o Swing, según la factory elegida)
        String opType = input.getOperationType();
        double[] operands = input.getOperands();

        // 5. Factory Method — crea la operación correcta
        Operation operation = OperationFactory.create(opType);

        // 6. Ejecutar la operación
        double result = operation.execute(operands[0], operands[1]);

        // 7. Mostrar el resultado (cada OutputRenderer lo hace a su manera)
        output.render(new CalculationResult(operation.getName(), result));
    }
}
