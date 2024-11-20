package Calculadora.abstractClasses;

import java.util.List;

import Calculadora.interfaces.CharAllowedInterface;
import Calculadora.interfaces.VerificateOperationInterface;

public class VerificateOperationClass implements VerificateOperationInterface {
    private List<Character> operators;
    private CharAllowedInterface charAllowedInterface;

    public VerificateOperationClass() {
        this.charAllowedInterface = new CharsAllowedClass();
        this.operators = charAllowedInterface.getCharAllowed();
    }

    @Override
    public boolean isOperator(char element) {
        return operators.contains(element);
    }

}
