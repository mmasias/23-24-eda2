import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Encuentra el índice del elemento más pequeño
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

            System.out.println("Iteración " + (i + 1) + ": " + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] data = {29, 20, 73, 34, 64};
        System.out.println("Array original: " + Arrays.toString(data));
        sort(data);
        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(data));
    }
}