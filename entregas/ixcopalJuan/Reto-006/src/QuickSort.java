public class QuickSort {
    // Método para realizar el ordenamiento
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            // Particiona el arreglo y obtiene el índice del pivote en su posición correcta
            int pivotIndex = partition(array, low, high);

            // Ordena recursivamente los elementos antes y después de la partición
            System.out.println("Particionando y ordenando sub-arrays de " + low + " a " + (pivotIndex - 1));
            sort(array, low, pivotIndex - 1);
            System.out.println("Particionando y ordenando sub-arrays de " + (pivotIndex + 1) + " a " + high);
            sort(array, pivotIndex + 1, high);
        }
    }

    // Método para particionar el arreglo
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];  // Elige el último elemento como pivote
        int i = (low - 1);  // Índice de menor elemento

        System.out.println("\nParticionando el sub-array de índice " + low + " a " + high);
        System.out.println("Pivote seleccionado: " + pivot);

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

        System.out.println("Sub-array después de la partición:");
        for (int k = low; k <= high; k++) {
            System.out.print(array[k] + " ");
        }
        System.out.println("\nPivote colocado en su posición: " + (i + 1));

        return i + 1;  // Devuelve el índice del pivote
    }

    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        System.out.println("Array original:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println("\n");
        sort(data, 0, data.length - 1);
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
