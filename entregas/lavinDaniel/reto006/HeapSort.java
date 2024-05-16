package entregas.lavinDaniel.reto006;
public class HeapSort {

    public static void sort(int array[]) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);

            System.out.print("Array después de extraer el máximo (" + array[i] + "): ");
            printArray(array);
        }
    }

    static void heapify(int array[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if (l < n && array[l] > array[largest]) {
            largest = l;
        }

        if (r < n && array[r] > array[largest]) {
            largest = r;
        }

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;
            heapify(array, n, largest);
            System.out.print("Array después de heapify en posición " + i + ": ");
            printArray(array);
        }
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int array[] = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Array original:");
        printArray(array);
        System.out.println("=".repeat(60));
        sort(array);
        System.out.println("=".repeat(60));
        System.out.println("Array ordenado:");
        printArray(array);
    }
}