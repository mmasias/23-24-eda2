public class SelectionSort {
    public static void sort(int[] array) {
        for (int startIndex = 0; startIndex < array.length - 1; startIndex++) {
            int minIndex = findMinimumIndex(array, startIndex);
            swap(array, startIndex, minIndex);
            printArray(array);
        }
    }

    private static int findMinimumIndex(int[] array, int startIndex) {
        int minIndex = startIndex;
        for (int j = startIndex + 1; j < array.length; j++) {
            if (array[j] < array[minIndex]) {
                minIndex = j;
            }
        }
        System.out.println("Nuevo mínimo encontrado: " + array[minIndex] + " en índice " + minIndex);
        return minIndex;
    }

    private static void swap(int[] array, int i, int j) {
        System.out.println("Intercambiando " + array[i] + " con " + array[j]);
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    private static void printArray(int[] array) {
        System.out.print("Estado del array: ");
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
