package entregas.puenteDaniel.Reto006;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            System.out.println("Pivote seleccionado en índice " + pivotIndex + ": " + array[pivotIndex]);
            System.out.println("Arreglo parcial después de la partición: " + Arrays.toString(array));

            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];  // Elige el último elemento como pivote
        System.out.println("Pivote seleccionado: " + pivot);
        int i = (low - 1);  // Índice de menor elemento

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        System.out.println("Array original: " + Arrays.toString(data));
        sort(data, 0, data.length - 1);
        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(data));
    }
}