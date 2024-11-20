import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import Calculadora.abstractClasses.CharsAllowedClass;
import Calculadora.abstractClasses.NumbersAllowedClass;
import Calculadora.abstractClasses.OriginalTextClass;
import Calculadora.controllers.OperationManagerController;
import Calculadora.controllers.TextController;
import Calculadora.interfaces.CharAllowedInterface;
import Calculadora.interfaces.TextInterface;

public class App {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String txt;
        List<String> separated = new ArrayList<>();
        try {
            System.out.println("Comandos:\nExponente-> ^");
            System.out.println("Ingresa la operación:");
            txt = br.readLine();
            
            // Inicializamos los componentes necesarios
            TextInterface textInterface = new OriginalTextClass();
            CharAllowedInterface charAllowed = new CharsAllowedClass();
            System.out.println(charAllowed.getCharAllowed());
            CharAllowedInterface numbersAllowed = new NumbersAllowedClass();
            TextController textController = new TextController(textInterface, charAllowed, numbersAllowed);
            OperationManagerController operationManager = new OperationManagerController();

            // Filtrar texto y separar en números y operadores
            txt = textController.processTxtNumberChar(txt);
            separated = textController.separateNumbersAndChars(txt);
            textController.verificateOrderNumbersChars(separated);
            System.out.println("Matriz separada: " + separated);

            // Calcular resultado
            double result = operationManager.calculateResult(separated);
            System.out.println("Resultado: " + result);
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
