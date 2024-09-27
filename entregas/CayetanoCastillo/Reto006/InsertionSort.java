package entregas.CayetanoCastillo.Reto006;

import java.util.Arrays;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
            
            System.out.println("Paso " + i + ": " + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        System.out.println("Array original: " + Arrays.toString(data));
        sort(data);
        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(data));
    }
}
