import java.util.Random;

public class BogoSort {
    private static boolean isSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }

    private static void shuffle(int[] array) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomIndex = rand.nextInt(array.length);
            int tmp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = tmp;
        }
    }

    public static void sort(int[] array) {
        int attempt = 0;
        while (!isSorted(array)) {
            System.out.println("Intento " + (attempt + 1) + ":");
            printArray(array);
            shuffle(array);
            attempt++;
        }
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {3, 2, 5, 0, 4};
        System.out.println("Array original:");
        printArray(data);

        sort(data);

        System.out.println("Array ordenado después de " + data.length + " intentos:");
        printArray(data);
    }
}
