package entregas.garciaLydia.reto006;

public class BubbleSort {
    public static void sort(int[] array) {
        boolean swapped;
        int passIndex = 0;
        do {
            swapped = false;
            for (int j = 0; j < array.length - 1 - passIndex; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            passIndex++;
            System.out.println("Estado del array en la iteración " + passIndex + ":");
            for (int i : array) {
                System.out.print(i + " ");
            }
            System.out.println();
        } while (swapped);
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();

        sort(data);

        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
