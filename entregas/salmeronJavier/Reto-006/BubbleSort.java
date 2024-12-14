public class BubbleSort {
    public static void sort(int[] array) {
        int n = array.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            System.out.println("Pasada número " + (i + 1));
            for (int j = 0; j < n - 1 - i; j++) {
                System.out.println("Comparando: " + array[j] + " y " + array[j + 1]);
                if (array[j] > array[j + 1]) {
                    System.out.println("Intercambiando: " + array[j] + " con " + array[j + 1]);
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            System.out.print("Estado del array después de la pasada " + (i + 1) + ": ");
            for (int k : array) {
                System.out.print(k + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println("\nComenzando el ordenamiento...");
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
