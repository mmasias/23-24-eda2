public class BubbleSort {
    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) { // i es el número de pasadas completas
            System.out.println("Pasada " + (i + 1) + ":");
            for (int j = 0; j < n - 1; j++) { // j es el índice para comparar elementos adyacentes
                System.out.print("Comparando " + array[j] + " y " + array[j + 1]);
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    System.out.println(" => intercambiados para obtener: " + array[j] + " y " + array[j + 1]);
                } else {
                    System.out.println(" => no se intercambiaron");
                }
            }
            System.out.print("Arreglo después de la pasada " + (i + 1) + ": ");
            for (int k = 0; k < n; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Arreglo original: ");
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println("\nIniciando el proceso de ordenamiento...");
        sort(data);
        System.out.println("\nArray ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
