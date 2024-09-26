package entregas.lavinDaniel.reto006;

public class MergeSort {
    public static void sort(int[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            sort(array, left, middle);
            sort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;

        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
            imprimirEstado(array);

        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
            imprimirEstado(array);

        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
            imprimirEstado(array);

        }
    }

    public static void imprimirEstado(int[] array) {
        System.out.print("Estado del Array: ");
        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Array original:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("=".repeat(40));
        sort(data, 0, data.length - 1);
        System.out.println("=".repeat(40));
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}