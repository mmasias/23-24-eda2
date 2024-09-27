package entregas.garciaDiego.Reto006;

public class QuickSort {
    // Método para realizar el ordenamiento
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            System.out.println("Se particiona el array en dos partes...");
            int pivotIndex = partition(array, low, high);
            System.out.println("Indice del pivote: " + pivotIndex);

            System.out.println("Se ordenan los elementos menores al pivote y los mayores al pivote");
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    // Método para particionar el arreglo
    private static int partition(int[] array, int low, int high) {
        System.out.println("Se elige el último elemento como pivote");
        int pivot = array[high];
        int i = (low - 1); // Índice de menor elemento
        System.out.println("Pivote: " + pivot + ", Indice del número menor: " + i);

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor que el pivote
            if (array[j] < pivot) {
                System.out.println("El número " + array[j] + " es menor que el pivote " + pivot);
                i++;

                System.out.println("Se intercambia " + array[i] + " y " + array[j]);
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        System.out.println("Se intercambia el pivote " + array[high] + " con el número en la posición "+ (i + 1) + " que es el "+ array[i + 1]);
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1; // Devuelve el índice del pivote
    }

    public static void main(String[] args) {
        int[] data = { 10, 7, 8, 9, 1, 5 };
        sort(data, 0, data.length - 1);
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
