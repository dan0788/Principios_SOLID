package Calculadora.abstractClasses.Operaciones;

import Calculadora.interfaces.OperationInterface;

public class DivisionClass implements OperationInterface {

    @Override
    public double operate(double num1, double num2) {
        if (num2 == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return num1 / num2;
    }

}
