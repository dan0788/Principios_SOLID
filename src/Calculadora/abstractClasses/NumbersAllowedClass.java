package Calculadora.abstractClasses;

import java.util.ArrayList;
import java.util.List;

import Calculadora.interfaces.CharAllowedInterface;

public class NumbersAllowedClass implements CharAllowedInterface{
    private List<Character> numbers;

    public NumbersAllowedClass() {
        numbers = new ArrayList<>();
        for (char c = '0'; c <= '9'; c++) {
            numbers.add(c);
        }
        numbers.add('.');
    }

    @Override
    public List<Character> getCharAllowed() {
        return numbers;
    }
}
