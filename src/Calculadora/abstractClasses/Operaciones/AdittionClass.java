package Calculadora.abstractClasses.Operaciones;

import Calculadora.interfaces.OperationInterface;

public class AdittionClass implements OperationInterface {
    @Override
    public double operate(double num1, double num2){
        return num1+num2;
    }
}
