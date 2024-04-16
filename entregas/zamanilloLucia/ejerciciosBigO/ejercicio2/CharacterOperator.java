package entregas.zamanilloLucia.ejerciciosBigO.ejercicio2;

import java.util.ArrayList;

public class CharacterOperator {

    public ArrayList<Integer> wordIndexCalculator(String[] wordArray, String chosenWord) {
        int chosenWordPointer;
        int arrayPointer;
        ArrayList<Integer> result = new ArrayList<Integer>();

       for (chosenWordPointer = 0; chosenWordPointer < chosenWord.length(); chosenWordPointer++) {
            for (arrayPointer = 0; arrayPointer < wordArray.length; arrayPointer++) {
                String character = String.valueOf(chosenWord.charAt(chosenWordPointer));
                if (wordArray[arrayPointer].equals(character)) {
                    result.add(arrayPointer);
                }
            }
        }
        return result;

    
    }
}
