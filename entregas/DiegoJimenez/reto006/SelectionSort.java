public class SelectionSort {
    public static void sort(int[] array) {
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            System.out.println("Iteración " + (startIndex + 1) + ":");
            int minIndex = startIndex;
            for (int j = startIndex + 1; j < array.length; j++) {
                System.out.println("Comparando " + array[minIndex] + " con " + array[j]);
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Encuentra el índice del elemento más pequeño
                }
            }
            System.out.println("Intercambio " + array[minIndex] + " con " + array[startIndex]);
            // Intercambio del elemento mínimo encontrado con el elemento en startIndex
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;
            System.out.print("Array después de la iteración " + (startIndex + 1) + ": [");
            for (int k = 0; k < array.length; k++) {
                System.out.print(array[k]);
                if (k < array.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
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