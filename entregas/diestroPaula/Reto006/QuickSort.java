package entregas.diestroPaula.Reto006;

public class QuickSort {
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            // Encontrar el índice del pivote después de particionar
            int pivotIndex = partition(array, low, high);

            // Ordenar la parte izquierda del pivote (menores que el pivote)
            sort(array, low, pivotIndex - 1);
            // Ordenar la parte derecha del pivote (mayores que el pivote)
            sort(array, pivotIndex + 1, high);

            // Mostrar el estado del arreglo después de particionar
            System.out.println("Array después de particionar con pivote " + array[pivotIndex] + ":");
            printArray(array);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Seleccionar el pivote como el último elemento
        int i = (low - 1); // Índice del elemento más pequeño

        // Recorrer el arreglo y mover los elementos menores que el pivote hacia la
        // izquierda
        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                // Intercambiar array[i] y array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Intercambiar array[i+1] y el pivote (array[high])
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        // Retornar el índice del pivote después de la partición
        return i + 1;
    }

    // Método para imprimir el arreglo
    static void printArray(int array[]) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Array original:");
        printArray(data); // Imprimir el arreglo original
        sort(data, 0, data.length - 1); // Llamar al método sort para ordenar el arreglo
        System.out.println("Array ordenado:");
        printArray(data); // Imprimir el arreglo ordenado
    }
}