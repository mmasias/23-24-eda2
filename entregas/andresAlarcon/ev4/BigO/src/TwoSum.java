import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] numeros = { 3, 2, 9, 8 };
        int objetivo = 10;
        int[] indices = encontrarIndices(numeros, objetivo);

        if (indices != null) {
            System.out.println(
                    "Los índices de los números que suman " + objetivo + " son: " + indices[0] + " y " + indices[1]);
        } else {
            System.out.println("No se encontraron dos números que sumen " + objetivo);
        }
    }

    public static int[] encontrarIndices(int[] numeros, int objetivo) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numeros.length; i++) {
            int complemento = objetivo - numeros[i];
            if (map.containsKey(complemento)) {
                return new int[] { map.get(complemento), i };
            }
            map.put(numeros[i], i);
        }
        return null;
    }
}