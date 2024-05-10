public class InsertionSort {
    public static void sort(int[] array) {
        // Recorre el array para comparar elementos adyacentes y ordenarlos de menor a mayor
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            // Compara el elemento actual con el resto de elementos del array
            while (j >= 0 && array[j] > current) {
                // Si el elemento actual es menor que el elemento anterior, se intercambian
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
        }
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        sort(data);
        System.out.println("Array ordenado:");
        for (int value : data) {
            System.out.print(value + " ");
        }
    }
}