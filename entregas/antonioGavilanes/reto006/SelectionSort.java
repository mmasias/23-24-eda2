public class SelectionSort {

    public static void sort(int[] array) {
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            int minIndex = startIndex;
            System.out.println("Iniciando búsqueda del mínimo desde el índice " + startIndex);
            for (int j = startIndex + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Nuevo índice del mínimo
                    System.out.println("Nuevo mínimo encontrado: " + array[minIndex] + " en el índice " + minIndex);
                }
            }
            // Intercambio de elementos
            System.out.println("Intercambiando " + array[startIndex] + " con " + array[minIndex]);
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;

            // Mostrar el estado del arreglo después del intercambio
            System.out.print("Estado del arreglo después del intercambio: ");
            for (int k : array) {
                System.out.print(k + " ");
            }
            System.out.println("\n");
            startIndex++;
        }
    }

    public static void main(String[] args) {
        int[] data = { 29, 20, 73, 34, 64 };
        System.out.println("Array original: ");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println("\nComenzando ordenamiento por selección:");
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
