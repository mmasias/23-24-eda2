public class SelectionSort {
    public static void sort(int[] array) {
        int startIndex = 0; // Índice de inicio del arreglo

        // Iterar sobre el arreglo hasta el penúltimo elemento
        while (startIndex < array.length - 1) {
            int minIndex = startIndex; // Índice del elemento mínimo inicialmente es el de inicio
            // Buscar el índice del elemento mínimo en el subarreglo restante
            for (int j = startIndex + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Actualizar el índice del elemento mínimo
                }
            }
            // Intercambiar el elemento mínimo con el primer elemento del subarreglo restante
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;

            // Mostrar el estado actual del arreglo después de cada iteración
            System.out.println("Estado del arreglo después de la iteración " + (startIndex + 1) + ":");
            printArray(array);

            startIndex++; // Mover al siguiente elemento
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
        int[] data = {29, 20, 73, 34, 64};
        System.out.println("Array original:");
        printArray(data); // Imprimir el arreglo original
        sort(data); // Llamar al método sort para ordenar el arreglo
        System.out.println("Array ordenado:");
        printArray(data); // Imprimir el arreglo ordenado
    }
}