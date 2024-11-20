package Calculadora.abstractClasses;

import java.util.ArrayList;
import java.util.List;

import Calculadora.interfaces.CharAllowedInterface;

public class CharsAllowedClass implements CharAllowedInterface {
    private List<Character> operators;

    public CharsAllowedClass() {
        operators = new ArrayList<>();
        operators.add('+');
        operators.add('-');
        operators.add('*');
        operators.add('/');
        operators.add('^');
    }

    @Override
    public List<Character> getCharAllowed() {
        return operators;
    }

}
