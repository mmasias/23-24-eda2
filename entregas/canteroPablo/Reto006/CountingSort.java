public class CountingSort {
    public void sort(int[] array) {
        int length = array.length;
        int[] output = new int[length];

        int max = findMax(array);
        System.out.println("Máximo valor en el array: " + max);

        int[] count = new int[max + 1];
        countOccurrences(array, count);

        System.out.print("Frecuencias iniciales: ");
        printArray(count);

        accumulateFrequencies(count);

        System.out.print("Frecuencias acumuladas: ");
        printArray(count);

        constructOutput(array, output, count);

        copyOutputToOriginalArray(array, output);

        System.out.print("Array final ordenado: ");
        printArray(array);
    }

    private int findMax(int[] array) {
        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    private void countOccurrences(int[] array, int[] count) {
        for (int num : array) {
            count[num]++;
        }
    }

    private void accumulateFrequencies(int[] count) {
        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }
    }

    private void constructOutput(int[] array, int[] output, int[] count) {
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
            System.out.print("Construcción del array de salida: ");
            printArray(output);
        }
    }

    private void copyOutputToOriginalArray(int[] array, int[] output) {
        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }

    private void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CountingSort obj = new CountingSort();
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        System.out.print("Array original: ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println("\nComenzando el ordenamiento...");
        obj.sort(data);
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
