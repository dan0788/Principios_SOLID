package Calculadora.controllers;

import java.util.ArrayList;
import java.util.List;
import Calculadora.interfaces.CharAllowedInterface;
import Calculadora.interfaces.TextInterface;

public class TextController {
    private TextInterface textInterface;
    private CharAllowedInterface charAllowedInterface;
    private CharAllowedInterface numbersAllowedInterface;
    private List<Character> numbers;
    private List<Character> chars;
    private List<String> separated;

    public TextController(TextInterface textInterface, CharAllowedInterface charAllowedInterface,
            CharAllowedInterface numbersAllowedInterface) {
        this.textInterface = textInterface;
        this.charAllowedInterface = charAllowedInterface;
        this.numbersAllowedInterface = numbersAllowedInterface;
        this.numbers = numbersAllowedInterface.getCharAllowed();
        this.chars = charAllowedInterface.getCharAllowed();
        this.separated = new ArrayList<>();
    }

    public String processTxtNumberChar(String txt) {
        /*
         * if (txt.matches(".*[A-Za-z].*")) {
         * System.out.println("No se permiten letras");
         * return;
         * }
         */
        txt = textInterface.getTxt(txt);
        String string = "";
        for (char element : txt.toCharArray()) {
            if (numbers.contains(element) || chars.contains(element)) {
                string += element;
            }
        }
        return string;
    }

    public List<String> separateNumbersAndChars(String txt) {
        List<String> separated = new ArrayList<>();
        String string = "";
        char[] arrayChar = txt.toCharArray();
        for (int i = 0; i < arrayChar.length; i++) {
            char currentChar = arrayChar[i];
            if (i > 0) {
                char pastChar = arrayChar[i - 1];
                if (numbers.contains(currentChar)) {
                    if (chars.contains(pastChar)) {
                        string = "" + currentChar;
                    } else if (numbers.contains(pastChar)) {
                        string += currentChar;
                    }
                } else if (chars.contains(currentChar)) {
                    if (chars.contains(pastChar)) {
                        separated.add(Character.toString(currentChar));
                    } else if (numbers.contains(pastChar)) {
                        separated.add(string);
                        separated.add(Character.toString(currentChar));
                    }
                    string = "" + currentChar;
                }
            } else {
                string += currentChar;
            }
            if (i == arrayChar.length - 1) {
                separated.add(string);
            }
        }
        return this.separated = separated;
    }

    public void verificateOrderNumbersChars(List<String> separated) throws Exception {
        for (int i = 0; i < separated.size(); i++) {
            String currentValue = separated.get(i);
            if (i > 0) {
                String pastValue = separated.get(i - 1);
                if (chars.contains(currentValue.charAt(0))) {
                    if (chars.contains(pastValue.charAt(0))) {
                        throw new Exception("No puede haber dos operadores juntos");
                    }
                }
            }
        }
    }
}
