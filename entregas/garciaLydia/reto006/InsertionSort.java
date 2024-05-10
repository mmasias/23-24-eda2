package entregas.garciaLydia.reto006;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                System.out.println("Estado del array en la iteración " + i + ":");
                for (int k = 0; k < array.length; k++) {
                    if (k == j + 1)
                        System.out.print(current + " ");
                    else
                        System.out.print(array[k] + " ");
                }
                System.out.println();
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        System.out.println("Array original:");
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println();

        sort(data);

        System.out.println("Array ordenado:");
        for (int value : data) {
            System.out.print(value + " ");
        }
    }
}
