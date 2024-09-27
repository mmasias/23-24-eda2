package entregas.CayetanoCastillo.Reto006;

import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] array) {
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            int minIndex = startIndex;
            for (int j = startIndex + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;
            startIndex++;
            
            System.out.println("Paso " + startIndex + ": " + Arrays.toString(array));
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
