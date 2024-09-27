public class MergeSort {

    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            // Encontrar el punto medio del arreglo
            int middle = (left + right) / 2;

            // Ordenar la primera mitad
            sort(array, left, middle);
            // Ordenar la segunda mitad
            sort(array, middle + 1, right);

            // Fusionar las mitades ordenadas
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {

        // Tamaño de las dos mitades
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Arreglos temporales para almacenar las mitades
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copiar los elementos a los arreglos temporales
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];
        }

        // Índices iniciales de los arreglos temporales
        int i = 0, j = 0;

        // Índice inicial del arreglo original
        int k = left;

        // Fusionar las dos mitades ordenadas
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;

            // Mostrar el estado actual del arreglo durante la fusión
            System.out.println("Estado actual del arreglo durante la fusión:");
            printArray(array);
        }

        // Copiar los elementos restantes de L[] si hay alguno
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de R[] si hay alguno
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Método para imprimir el arreglo
    static void printArray(int array[]) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Array original:");
        printArray(data); // Imprimir el arreglo original
        sort(data, 0, data.length - 1); // Llamar al método sort para ordenar el arreglo
        System.out.println("\nArray ordenado:");
        printArray(data); // Imprimir el arreglo ordenado
    }
}