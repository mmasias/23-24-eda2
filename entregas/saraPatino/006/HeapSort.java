public class HeapSort {
    public static void sort(int array[]) {
        int n = array.length;

        // Paso 1: Construyendo el montículo
        System.out.println("Construyendo el montículo:");
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i); // Ajustar el montículo en la posición i
            printArray(array); // Imprimir el estado actual del arreglo
        }

        // Paso 2: Extrayendo elementos del montículo
        System.out.println("\nExtrayendo elementos del montículo:");
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0); // Ajustar el montículo en el segmento restante del arreglo
            printArray(array); // Imprimir el estado actual del arreglo
        }
    }

    static void heapify(int array[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 

        if (l < n && array[l] > array[largest])
            largest = l;

        if (r < n && array[r] > array[largest])
            largest = r;

        // Si el nodo actual no es el más grande, intercambiar con el más grande
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest); // Llamar recursivamente para ajustar el subárbol afectado
        }
    }

    static void printArray(int array[]) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int array[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Array original:");
        printArray(array);
        sort(array);
        System.out.println("\nArray ordenado:");
        printArray(array);
    }
}