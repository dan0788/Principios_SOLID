package Calculadora.abstractClasses.Operaciones;

import Calculadora.interfaces.OperationInterface;

public class ExponentialClass implements OperationInterface {

    @Override
    public double operate(double num1, double num2) {
        return Math.pow(num1, num2);
    }

}
