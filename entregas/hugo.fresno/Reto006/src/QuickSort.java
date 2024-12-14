public class QuickSort {
    // Método para realizar el ordenamiento
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            // Particiona el arreglo y obtiene el índice del pivote en su posición correcta
            int pivotIndex = partition(array, low, high);

            System.out.println("Pivote seleccionado en índice " + pivotIndex + ", valor " + array[pivotIndex]);
            System.out.println("Subarreglo izquierdo a ordenar: " + arrayToString(array, low, pivotIndex - 1));
            System.out.println("Subarreglo derecho a ordenar: " + arrayToString(array, pivotIndex + 1, high));

            // Ordena recursivamente los elementos antes y después de la partición
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    // Método para particionar el arreglo
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];  // Elige el último elemento como pivote
        int i = (low - 1);  // Índice de menor elemento
        System.out.println("Particionando con pivote " + pivot + " entre índices " + low + " y " + high);

        for (int j = low; j < high; j++) {
            System.out.print("Comparando " + array[j] + " con pivote " + pivot);
            // Si el elemento actual es menor que el pivote
            if (array[j] < pivot) {
                i++;

                // Intercambia arr[i] y arr[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                System.out.println(" => intercambiados para obtener: " + arrayToString(array, low, high));
            } else {
                System.out.println(" => no intercambiados");
            }
        }

        // Intercambia el elemento pivote con el elemento en la posición i+1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        System.out.println("Pivote " + pivot + " intercambiado con " + array[i + 1] + " para obtener: " + arrayToString(array, low, high));

        return i + 1;  // Devuelve el índice del pivote
    }

    private static String arrayToString(int[] array, int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = start; i <= end; i++) {
            sb.append(array[i]);
            if (i < end) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        System.out.println("Array original:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        sort(data, 0, data.length - 1);
        System.out.println("\nArray ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
