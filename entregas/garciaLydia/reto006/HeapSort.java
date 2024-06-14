package entregas.garciaLydia.reto006;

public class HeapSort {
    public static void sort(int array[]) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapify(array, i, 0);

            System.out.println("Estado del array en la iteración " + (n - i) + ":");
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
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

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int array[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Array original:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        sort(array);

        System.out.println("Array ordenado:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
