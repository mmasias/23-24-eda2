package entregas.puenteDaniel.Reto006;

public class CountingSort {
    public void sort(int[] array) {
        System.out.println("Traza");
        System.out.println("Arreglo de entrada: " + arrayToString(array));

        // Encontrar el valor máximo en el arreglo de entrada
        int max = findMax(array);
        System.out.println("Max value (k): " + max);

        // Inicializar el arreglo de conteo
        int[] count = new int[max + 1];
        System.out.println("Arreglo de conteo inicializado: " + arrayToString(count));

        // Paso 1: Contar
        System.out.println("Paso 1: contar");
        countElements(array, count);

        // Paso 2: Acumular
        System.out.println("Paso 2: acumular");
        accumulateCount(count);

        // Paso 3: Colocar
        System.out.println("Paso 3: colocar");
        placeElements(array, count);

        System.out.println("Final");
        System.out.println("Arreglo ordenado: " + arrayToString(array));
    }

    // Método auxiliar para convertir un arreglo en una cadena de texto
    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    // Método auxiliar para encontrar el valor máximo en el arreglo
    private int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // Método auxiliar para contar los elementos en el arreglo de entrada
    private void countElements(int[] array, int[] count) {
        for (int i = 0; i < array.length; i++) {
            count[array[i]]++;
        }
        System.out.println("Conteo de elementos: " + arrayToString(count));
    }

    // Método auxiliar para acumular el conteo de elementos
    private void accumulateCount(int[] count) {
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
        System.out.println("Acumulación: " + arrayToString(count));
    }

    // Método auxiliar para colocar los elementos en el arreglo de salida
    private void placeElements(int[] array, int[] count) {
        int[] output = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }
        System.arraycopy(output, 0, array, 0, array.length);
    }

    public static void main(String[] args) {
        CountingSort obj = new CountingSort();
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        obj.sort(data);
    }
}
