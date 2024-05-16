package entregas.gomezSantiago.Reto006.AlgoritmosOrdenacion;

public class QuickSort {
    // Método para realizar el ordenamiento
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            System.out.println("+--------------------------------------------------------------+");
            System.out.println("| Llamada a la función sort con los índices " + low + " y " + high);
            System.out.println("+--------------------------------------------------------------+");

            // Particiona el arreglo y obtiene el índice del pivote en su posición correcta
            int pivotIndex = partition(array, low, high);

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

    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        System.out.println("+---------------------+");
        System.out.println("| Array original:");
        System.out.println("+---------------------+");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println("\n\nPasos del algoritmo Quick Sort:");

        // Llamada inicial al método sort
        sort(data, 0, data.length - 1);

        System.out.println("\n+-------------------+");
        System.out.println("| Array ordenado:");
        System.out.println("+---------------------+");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
