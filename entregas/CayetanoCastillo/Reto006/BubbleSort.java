package entregas.CayetanoCastillo.Reto006;

import java.util.Arrays;

public class BubbleSort {
    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                
                System.out.println("Paso " + (i*n + j + 1) + ": " + Arrays.toString(array));
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original: " + Arrays.toString(data));
        sort(data);
        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(data));
    }
}
