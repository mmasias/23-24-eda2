public class InsertionSort {
    public static void sort(int[] array) {
        System.out.println("Comenzando el ordenamiento:");
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            System.out.println("Elemento seleccionado para insertar: " + current);

            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];
                j--;
                System.out.println("Después de desplazar: ");
                printArray(array);
            }
            array[j + 1] = current;

            System.out.println("Después de insertar: ");
            printArray(array);
        }
    }

    public static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        System.out.println("Array original:");
        printArray(data);

        sort(data);

        System.out.println("Array ordenado:");
        printArray(data);
    }
}
