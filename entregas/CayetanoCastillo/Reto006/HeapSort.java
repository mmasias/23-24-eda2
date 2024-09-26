package entregas.CayetanoCastillo.Reto006;

import java.util.Arrays;

public class HeapSort {
    public static void sort(int array[]) {
        int n = array.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);
        System.out.println("Heapified array: " + Arrays.toString(array));

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            heapify(array, i, 0);
            System.out.println("Heapify step " + (n - i) + ": " + Arrays.toString(array));
        }
    }

    static void heapify(int array[], int n, int i) {
    int largest = i; // Inicializar largest como raíz
        int l = 2 * i + 1; // izquierda = 2*i + 1
        int r = 2 * i + 2; // derecha = 2*i + 2

        // Si el hijo izquierdo es mayor que la raíz
        if (l < n && array[l] > array[largest])
            largest = l;

        // Si el hijo derecho es mayor que largest hasta ahora
        if (r < n && array[r] > array[largest])
            largest = r;

        // Si largest no es la raíz
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursivamente heapificar el subárbol afectado
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int array[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Array original: " + Arrays.toString(array));
        sort(array);
        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(array));
    }
}

