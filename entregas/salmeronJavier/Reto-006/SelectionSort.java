public class SelectionSort {
    public static void sort(int[] array) {
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            int minIndex = startIndex;
            System.out.println("Buscando el mínimo desde el índice " + startIndex);

            for (int j = startIndex + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                    System.out.println("Nuevo mínimo encontrado: " + array[minIndex] + " en índice " + minIndex);
                }
            }

            System.out.println("Intercambiando " + array[startIndex] + " con " + array[minIndex]);
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;

            System.out.print("Array después del intercambio: ");
            printArray(array);

            startIndex++;
        }
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
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
