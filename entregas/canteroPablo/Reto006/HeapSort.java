public class HeapSort {
    public static void sort(int[] array) {
        int n = array.length;

        System.out.println("Construyendo el montículo:");
        buildMaxHeap(array, n);

        for (int i = n - 1; i > 0; i--) {
            swap(array, 0, i);
            System.out.println("Montículo después de mover la raíz al final:");
            printArray(array);
            heapify(array, i, 0);
        }
    }

    static void buildMaxHeap(int[] array, int n) {
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
            System.out.print("Montículo después de index " + i + ": ");
            printArray(array);
        }
    }

    static void heapify(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest])
            largest = left;

        if (right < n && array[right] > array[largest])
            largest = right;

        if (largest != i) {
            swap(array, i, largest);
            System.out.println("Heapify llamado en índice " + i + " (intercambio entre " + array[largest] + " y " + array[i] + ")");
            heapify(array, n, largest);
        }
    }

    static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Array original:");
        printArray(array);
        System.out.println("Comenzando el ordenamiento...");
        sort(array);
        System.out.println("Array ordenado:");
        printArray(array);
    }
}
