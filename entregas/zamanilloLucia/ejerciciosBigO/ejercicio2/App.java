package entregas.zamanilloLucia.ejerciciosBigO.ejercicio2;

import java.util.ArrayList;


public class App {
    public static void main(String[] args) {
        String[] array = {"a", "c", "d", "i", "m", "r", "t", "u"};
        String word = "dia";

        CharacterOperator charOperator = new CharacterOperator();
        ArrayList<Integer> result = charOperator.wordIndexCalculator(array, word);

        System.out.println(result);
        
    }
}
