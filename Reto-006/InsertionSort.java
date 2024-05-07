public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];  // Desplaza el elemento hacia la derecha
                j--;

                // Imprime el estado actual del arreglo durante el desplazamiento
                System.out.println("Desplazamiento: " + (j + 1) + " <- " + (j + 2));
                printArray(array);
            }
            array[j + 1] = current; // Inserta el elemento en su lugar correcto

            // Imprime el estado actual del arreglo después de la inserción
            System.out.println("Inserción de " + current + " en la posición " + (j + 1));
            printArray(array);
        }
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        System.out.println("Array original:");
        printArray(data);
        sort(data);
        System.out.println("Array ordenado:");
        printArray(data);
    }

    // Método para imprimir un arreglo
    static void printArray(int array[]) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
