package Calculadora.abstractClasses;

import Calculadora.interfaces.TextInterface;

public class UpperCaseClass implements TextInterface {

    @Override
    public String getTxt(String txt) {
        return txt.toUpperCase();
    }
    
}
