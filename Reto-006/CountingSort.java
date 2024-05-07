public class CountingSort {
    public void sort(int[] array) {
        int length = array.length;
        // El arreglo de salida que tendrá los elementos ordenados
        int output[] = new int[length];

        // Encuentra el elemento mayor para saber el rango
        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        // Arreglo de conteo
        int count[] = new int[max + 1];

        // Almacenar el conteo de cada elemento
        for (int i = 0; i < length; i++) {
            count[array[i]]++;
        }

        // Imprimir el arreglo de conteo
        System.out.println("Arreglo de conteo:");
        printArray(count);

        // Cambiar count[i] para que count[i] contenga la posición actual
        // de este elemento en output[]
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Imprimir el arreglo de conteo modificado
        System.out.println("Arreglo de conteo modificado:");
        printArray(count);

        // Construir el arreglo de salida
        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;

            // Imprimir el proceso de construcción del arreglo de salida
            System.out.println("Paso " + (length - i) + ":");
            printArray(output);
            printArray(count);
        }

        // Copiar los elementos ordenados al arreglo original
        for (int i = 0; i < length; i++) {
            array[i] = output[i];
        }
    }

    // Método para imprimir un arreglo
    static void printArray(int array[]) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CountingSort obj = new CountingSort();
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Array original:");
        printArray(data);
        obj.sort(data);
        System.out.println("Array ordenado:");
        printArray(data);
    }
}
