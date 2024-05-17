public class MergeSort {

    // Método principal que ordena el arreglo usando el algoritmo MergeSort.
    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            // Encuentra el punto medio del arreglo para dividirlo en dos mitades.
            int middle = (left + right) / 2;

            System.out.println(
                    "Dividiendo array desde índice " + left + " hasta " + right + " con punto medio en " + middle);

            // Ordena las dos mitades.
            sort(array, left, middle);
            sort(array, middle + 1, right);

            // Fusiona las dos mitades.
            merge(array, left, middle, right);
        }
    }

    // Fusiona dos subarreglos de array[].
    private static void merge(int[] array, int left, int middle, int right) {
        // Encuentra los tamaños de los dos subarreglos a fusionar.
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Arreglos temporales.
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia los datos a los arreglos temporales.
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];
        }

        System.out.println("Fusionando: [" + arrayToString(L) + "] y [" + arrayToString(R) + "]");

        // Índices iniciales de los subarreglos.
        int i = 0, j = 0;

        // Índice inicial del subarreglo fusionado.
        int k = left;

        // Fusionar los arreglos temporales.
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

        // Copiar los elementos restantes de R, si los hay.
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
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
