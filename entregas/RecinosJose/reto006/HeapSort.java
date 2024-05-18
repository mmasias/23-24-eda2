public class HeapSort {

    public static void sort(int array[]) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            System.out.println("Construyendo montículo desde índice " + i);
            heapify(array, n, i);
            System.out.print("Estado del montículo después de ajustar en índice " + i + ": ");
            printArray(array);
        }

        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            System.out.println("Extracción del montículo máximo y colocación en posición " + i);
            heapify(array, i, 0);
            System.out.print("Estado del montículo después de extraer y ajustar: ");
            printArray(array);
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

        // Si el más grande no es la raíz
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            System.out.println("Swap " + array[i] + " con " + array[largest] + " en índice " + i + " y " + largest);
            heapify(array, n, largest);
        }
    }

    static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int array[] = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Array original:");
        printArray(array);
        sort(array);
        System.out.println("Array ordenado:");
        printArray(array);
    }
}
