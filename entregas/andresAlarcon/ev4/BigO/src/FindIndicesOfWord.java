import java.util.ArrayList;
import java.util.List;

public class FindIndicesOfWord {
    public static void main(String[] args) {
        char[] array = { 'a', 'c', 'd', 'i', 'm', 'r', 't', 'u' };
        String palabraClave = "dia";
        List<Integer> indices = findIndices(array, palabraClave);

        if (!indices.isEmpty()) {
            System.out.println("Los índices que forman la palabra '" + palabraClave + "' son: " + indices);
        } else {
            System.out.println("La palabra '" + palabraClave + "' no se encontró en el array.");
        }
    }

    public static List<Integer> findIndices(char[] array, String palabraClave) {
        List<Integer> indices = new ArrayList<>();
        for (char letra : palabraClave.toCharArray()) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == letra) {
                    indices.add(i);
                    break;
                }
            }
        }
        return indices;
    }
}