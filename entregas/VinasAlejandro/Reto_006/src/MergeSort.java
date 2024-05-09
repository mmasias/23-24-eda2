public class MergeSort {

    // Método para dividir y fusionar el array
    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            // Encuentra el punto medio del array.
            int middle = (left + right) / 2;

            // Ordena las dos mitades.
            sort(array, left, middle);
            sort(array, middle + 1, right);

            // Fusiona las mitades ordenadas.
            merge(array, left, middle, right);
        }
    }

    // Método para fusionar dos subarrays del array.
    private static void merge(int[] array, int left, int middle, int right) {
        // Tamaños de los subarrays.
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Arrays temporales.
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copiar los elementos a los arrays temporales.
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];
        }


        int i = 0, j = 0;

        // Índice inicial del array mezclado.
        int k = left;

        //Ordenar los elementos en el array.
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de L, si los hay.
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }


        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] data = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Array original:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        sort(data, 0, data.length - 1);
        System.out.println("\nArray ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}