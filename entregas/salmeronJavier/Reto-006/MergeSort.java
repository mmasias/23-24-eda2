public class MergeSort {
    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            System.out.println("Dividiendo el array desde " + left + " hasta " + right);
            System.out.println("Llamada recursiva izquierda: sort(" + left + ", " + middle + ")");

            sort(array, left, middle);

            System.out.println("Llamada recursiva derecha: sort(" + (middle + 1) + ", " + right + ")");
            sort(array, middle + 1, right);

            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.out.println("Copiando en subarrays para fusión, rango [" + left + ", " + right + "]:");
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];
        }

        System.out.print("Subarray izquierdo (L): ");
        for (int elem : L) {
            System.out.print(elem + " ");
        }
        System.out.println();

        System.out.print("Subarray derecho (R): ");
        for (int elem : R) {
            System.out.print(elem + " ");
        }
        System.out.println();

        int i = 0, j = 0;
        int k = left;

        System.out.println("Fusionando subarrays:");
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            System.out.println("Añadiendo " + array[k] + " en la posición " + k);
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            System.out.println("Añadiendo restantes de L: " + array[k] + " en la posición " + k);
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            System.out.println("Añadiendo restantes de R: " + array[k] + " en la posición " + k);
            j++;
            k++;
        }

        System.out.print("Array después de fusionar: ");
        for (int index = left; index <= right; index++) {
            System.out.print(array[index] + " ");
        }
        System.out.println();
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
