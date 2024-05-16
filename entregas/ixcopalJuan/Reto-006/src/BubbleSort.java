public class BubbleSort {
    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) { // i es el número de pasadas completas
            for (int j = 0; j < n - 1; j++) { // j es el índice para comparar elementos adyacentes
                if (array[j] > array[j + 1]) {
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                // Imprimir el estado actual del arreglo después de cada comparación
                System.out.print("Comparando " + array[j] + " con " + array[j + 1] + ": ");
                for (int k : array) {
                    System.out.print(k + " ");
                }
                System.out.print("\n");
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
