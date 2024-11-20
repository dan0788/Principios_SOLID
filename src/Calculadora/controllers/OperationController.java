package Calculadora.controllers;

import Calculadora.interfaces.OperationInterface;

public class OperationController {
    private OperationInterface operationInterface;

    public OperationController(OperationInterface operationInterface) {
        this.operationInterface = operationInterface;
    }

    public double execute(double num1, double num2) {
        return operationInterface.operate(num1, num2);
    }

}
