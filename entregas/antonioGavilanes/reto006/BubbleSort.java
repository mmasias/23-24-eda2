public class BubbleSort {
    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) { // i es el número de pasadas completas
            System.out.println("Pasada " + (i + 1) + ":");
            for (int j = 0; j < n - 1; j++) { // j es el índice que compara elementos cercanos
                System.out.print("Comparando " + array[j] + " y " + array[j + 1] + ": ");
                if (array[j] > array[j + 1]) {
                    // Cambio de posiciones
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    System.out.println("Intercambiados para -> " + array[j] + " " + array[j + 1]);
                } else {
                    System.out.println("Sin cambios.");
                }
            }
            // Mostrar el estado del arreglo después de cada pasada
            System.out.print("Estado del arreglo después de la pasada " + (i + 1) + ": ");
            for (int k : array) {
                System.out.print(k + " ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int[] data = { 64, 34, 25, 12, 22, 11, 90 };
        System.out.println("Array original: ");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println("\nComenzando ordenamiento Bubble Sort:");
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
