public class QuickSort {

    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            // Encuentra el índice del elemento pivote
            int pivotIndex = partition(array, low, high);

            // Ordena los elementos a la izquierda y a la derecha del pivote mediante recursión
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }


    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];  // Pivote
        int i = (low - 1); // Índice del elemento más pequeño

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor que el pivote intercambia arr[i] y arr[j]
            if (array[j] < pivot) {
                i++;


                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Intercambia el elemento pivote con el elemento en arr[i + 1] y lo devuelve
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
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