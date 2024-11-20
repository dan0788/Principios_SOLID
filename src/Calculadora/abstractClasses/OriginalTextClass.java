package Calculadora.abstractClasses;

import Calculadora.interfaces.TextInterface;

public class OriginalTextClass implements TextInterface {

    @Override
    public String getTxt(String txt) {
        return txt;
    }
    
}
