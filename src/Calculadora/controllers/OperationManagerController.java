package Calculadora.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Calculadora.abstractClasses.*;
import Calculadora.abstractClasses.Operaciones.AdittionClass;
import Calculadora.abstractClasses.Operaciones.DivisionClass;
import Calculadora.abstractClasses.Operaciones.ExponentialClass;
import Calculadora.abstractClasses.Operaciones.MultiplicationClass;
import Calculadora.abstractClasses.Operaciones.SubtractionClass;
import Calculadora.interfaces.CharAllowedInterface;
import Calculadora.interfaces.OperationInterface;
import Calculadora.interfaces.VerificateOperationInterface;

public class OperationManagerController {

    private VerificateOperationInterface verificateOperationInterface;
    private List<Character> operators;
    private CharAllowedInterface charAllowedInterface;
    private OperationController operationController;
    private Map<String, Class<? extends OperationInterface>> operationsMap;

    public OperationManagerController() {
        this.operationsMap = new HashMap<>();
        this.verificateOperationInterface = new VerificateOperationClass();
        this.charAllowedInterface = new CharsAllowedClass();
        this.operators = charAllowedInterface.getCharAllowed();
        registerOperations();
    }

    public double calculateResult(List<String> separated) {
        // podría dividirse en métodos más pequeños para mantener alta cohesión
        double result = 0.0;
        for (int i = 0; i < separated.size(); i++) {
            String element = separated.get(i);
            if (i == 0) {
                result = Double.parseDouble(element); // El primer elemento es el número inicial
            } else if (verificateOperationInterface.isOperator(element.charAt(0))) {
                String nextNumber = separated.get(i + 1);
                OperationInterface operationInterface = getOperationInterface(element);
                operationController = new OperationController(operationInterface);
                result = operationController.execute(result, Double.parseDouble(nextNumber));
                i++; // Saltar al siguiente número después del operador
            }
        }
        return result;
    }

    private OperationInterface getOperationInterface(String operator) {
        for (Map.Entry<String, Class<? extends OperationInterface>> entry : operationsMap.entrySet()) {
            if (entry.getKey().equals(operator)) {
                try {
                    return entry.getValue().getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    throw new RuntimeException("Error al instanciar la operación: " + operator, e);
                }
            }
        }
        throw new IllegalArgumentException("Operador no soportado: " + operator);
    }
    public void registerOperations() {
        operationsMap.put(Character.toString(operators.get(0)), AdittionClass.class);
        operationsMap.put(Character.toString(operators.get(1)), SubtractionClass.class);
        operationsMap.put(Character.toString(operators.get(2)), MultiplicationClass.class);
        operationsMap.put(Character.toString(operators.get(3)), DivisionClass.class);
        operationsMap.put(Character.toString(operators.get(4)), ExponentialClass.class);
    }
}
