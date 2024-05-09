
public class HeapSort {
    public static void sort(int array[]) {
        int n = array.length;

        // Realizar un montículo en el array para ordenar los elementos
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // Extraer elementos del montículo uno por uno
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = array[0];
            ararrayr[0] = array[i];
            array[i] = temp;

            // Llamar a heapify en el montículo reducido
            heapify(array, i, 0);
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

        // Si largest no es la raíz
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;


            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int array[] = {12, 11, 13, 5, 6, 7};
        sort(array);
        System.out.println("Array ordenado:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
