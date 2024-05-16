public class HeapSort {
    public static void sort(int[] array) {
        int n = array.length;

        System.out.println("Construyendo el montículo:");
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
            System.out.print("Montículo después de index " + i + ": ");
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            System.out.println("Montículo después de mover la raíz al final:");
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println();

            heapify(array, i, 0);
        }
    }

    static void heapify(int[] array, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largest])
            largest = l;

        if (r < n && array[r] > array[largest])
            largest = r;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            System.out.println("Heapify llamado en índice " + i + " (intercambio entre " + array[largest] + " y " + array[i] + ")");
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, 13, 5, 6, 7};
        System.out.println("Array original:");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println("\nComenzando el ordenamiento...");
        sort(array);
        System.out.println("Array ordenado:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
