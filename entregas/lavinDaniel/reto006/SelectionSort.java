package entregas.lavinDaniel.reto006;
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
            System.out.println("Intercambio " + array[startIndex] + " con " + array[minIndex]);
            startIndex++;
        }
    }

    public static void main(String[] args) {
        int[] data = { 29, 20, 73, 34, 64 };
        System.out.println("Array original:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("=".repeat(25));
        sort(data);
        System.out.println("=".repeat(25));
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}