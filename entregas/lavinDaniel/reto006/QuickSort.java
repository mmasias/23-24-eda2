package entregas.lavinDaniel.reto006;
public class QuickSort {
    public static void sort(int[] array, int low, int high) {
        if (low < high) {

            int pivotIndex = partition(array, low, high);

            System.out.print("Array después de particionar en pivote (" + array[pivotIndex] + "): ");
            printArray(array);

            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Array original:");
        printArray(data);
        System.out.println("=".repeat(60));
        sort(data, 0, data.length - 1);
        System.out.println("=".repeat(60));
        System.out.println("Array ordenado:");
        printArray(data);
    }
}