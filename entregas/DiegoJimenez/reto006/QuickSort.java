public class QuickSort {
    // Método para realizar el ordenamiento
    public static void sort(int[] array, int low, int high) {
        if (low < high) {

            if (low == 0 && high == array.length - 1) {
                System.out.println("Inicia con el arreglo:");
                printArray(array, low, high);
            }
            // Particiona el arreglo y obtiene el índice del pivote en su posición correcta
            int pivotIndex = partition(array, low, high);

            System.out.println("El pivote es: "  + array[pivotIndex]);
            System.out.println("Se realizan comparaciones y los elementos menores que " + array[pivotIndex] + " se mueven a la izquierda y los mayores a la derecha, con el pivote en la posición correcta al final de la partición.");
            System.out.println("Estado actual del arreglo:");
            printArray(array, low, high);
            System.out.println();

            // Ordena recursivamente los elementos antes y después de la partición
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    // Método para particionar el arreglo
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];  // Elige el último elemento como pivote
        int i = (low - 1);  // Índice de menor elemento

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor que el pivote
            if (array[j] < pivot) {
                i++;

                // Intercambia arr[i] y arr[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Intercambia el elemento pivote con el elemento en la posición i+1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;  // Devuelve el índice del pivote
    }

    private static void printArray(int[] array, int start, int end) {
        System.out.print("[");
        for (int i = start; i <= end; i++) {
            System.out.print(array[i]);
            if (i < end) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        sort(data, 0, data.length - 1);
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}