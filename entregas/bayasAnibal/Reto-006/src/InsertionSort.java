public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            System.out.println("Iteración " + i + ":");
            System.out.println("Elemento actual: " + current);
            System.out.println("Estado actual del arreglo antes de la inserción:");
            printArray(array);
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
            System.out.println("Estado actual del arreglo después de la inserción:");
            printArray(array);
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        System.out.println("Array original:");
        printArray(data);
        sort(data);
        System.out.println("Array ordenado:");
        printArray(data);
    }
}