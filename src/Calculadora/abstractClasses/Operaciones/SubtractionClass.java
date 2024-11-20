package Calculadora.abstractClasses.Operaciones;

import Calculadora.interfaces.OperationInterface;

public class SubtractionClass implements OperationInterface {
    @Override
    public double operate(double num1, double num2) {
        return num1 - num2;
    }
}
