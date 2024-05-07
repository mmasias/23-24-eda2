public class SelectionSort {
    public static void sort(int[] array) {
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            int minIndex = startIndex;
            for (int j = startIndex + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Encuentra el índice del elemento más pequeño
                }
            }
            // Intercambio del elemento mínimo encontrado con el elemento en startIndex
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;

            // Trazabilidad: Imprime el estado actual del arreglo después de cada iteración
            System.out.println("Estado del arreglo después de la iteración " + (startIndex + 1) + ":");
            printArray(array);

            startIndex++;
        }
    }

    // Método para imprimir un arreglo
    static void printArray(int array[]) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {29, 20, 73, 34, 64};
        System.out.println("Array original:");
        printArray(data);
        sort(data);
        System.out.println("Array ordenado:");
        printArray(data);
    }
}
