public class QuickSort {

    // Metodo para ordenar un arreglo usando QuickSort
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            // Encuentra el índice del pivote, el elemento en esta posición es ordenado
            int pivotIndex = partition(array, low, high);

            System.out.println("Pivote elegido en la posición " + pivotIndex + " con valor " + array[pivotIndex]);
            System.out.print("Estado del arreglo después de particionar: ");
            printArray(array);

            // Ordena los elementos antes y después del pivote
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    // Método para particionar el arreglo y devolver el índice del pivote
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; // Pivote
        int i = (low - 1); // Índice del elemento más pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor que el pivote
            if (array[j] < pivot) {
                i++;

                // Intercambia array[i] y array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                System.out.println(
                        "Intercambiando " + array[i] + " con " + array[j] + " por ser menor que el pivote " + pivot);
            }
        }

        // Intercambia array[i+1] y array[high] (o el pivote)
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        System.out.println("Intercambiando pivote " + array[i + 1] + " con " + pivot);

        return i + 1; // Devuelve el índice del pivote
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Array original:");
        printArray(data);
        sort(data, 0, data.length - 1);
        System.out.println("Array ordenado:");
        printArray(data);
    }
}
