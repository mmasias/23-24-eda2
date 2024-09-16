import java.util.Arrays;

public class CountingSort {
    public static void sort(int[] array) {
        System.out.println("Array original: " + Arrays.toString(array));

        int length = array.length;
        int output[] = new int[length];

        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        int count[] = new int[max + 1];

        for (int i = 0; i < length; i++) {
            count[array[i]]++;
        }

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        for (int i = 0; i < length; i++) {
            array[i] = output[i];
        }

        System.out.println("Array ordenado: " + Arrays.toString(array));
    }

    public static void main(String[] args) {
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        sort(data);
    }
}