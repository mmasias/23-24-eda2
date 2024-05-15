public class CountingSort {
    public void sort(int[] array) {
        int length = array.length;
        System.out.println("Array inicial: " + printArray(array));

        // El arreglo de salida que tendrá los elementos ordenados
        int output[] = new int[length];

        // Encuentra el elemento mayor para saber el rango
        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max) max = array[i];
        }

        // Arreglo de conteo
        int count[] = new int[max + 1];

        // Almacenar el conteo de cada elemento
        for (int i = 0; i < length; i++) {
            count[array[i]]++;
        }
        System.out.println("Arreglo de conteo: " + printArray(count));

        // Cambiar count[i] para que count[i] contenga la posición actual
        // de este elemento en output[]
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        System.out.println("Arreglo de conteo acumulado: " + printArray(count));

        // Construir el arreglo de salida
        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }
        System.out.println("Arreglo de salida: " + printArray(output));

        // Copiar los elementos ordenados al arreglo original
        for (int i = 0; i < length; i++) {
            array[i] = output[i];
        }
        System.out.println("Array ordenado: " + printArray(array));
    }

    // Método auxiliar para imprimir el array
    private static String printArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        CountingSort obj = new CountingSort();
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        obj.sort(data);
    }
}
