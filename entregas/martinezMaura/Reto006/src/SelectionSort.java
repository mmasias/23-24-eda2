public class SelectionSort {
    public static void sort(int[] array) {
        int startIndex = 0;
        System.out.println("Arreglo inicial: " + java.util.Arrays.toString(array));
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
            System.out.println("Paso " + startIndex + ": " + java.util.Arrays.toString(array));
            startIndex++;
        }
    }

    public static void main(String[] args) {
        int[] data = {29, 20, 73, 34, 64};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
