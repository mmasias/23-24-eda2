package entregas.zamanilloLucia.ejerciciosBigO.ejercicio1;

public class Operation {
    /*
     * La complejidad del algoritmo es de O(n^2) debido al doble bucle for
     */

    public int[] indexCalculator (int[] numArray, int targetNumber) {
        int firstPointer;
        int secondPointer;
        int[] indexResult = new int[2];

        for (firstPointer = 0; firstPointer < numArray.length; firstPointer++) {
            for (secondPointer = 0; secondPointer < numArray.length; secondPointer++) {
                if (numArray[firstPointer] + numArray[secondPointer] == targetNumber) {
                    indexResult[0] = firstPointer;
                    indexResult[1] = secondPointer;
                }
            }
        }
        return indexResult;
    }
}
