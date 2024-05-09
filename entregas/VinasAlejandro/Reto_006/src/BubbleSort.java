

public class BubbleSort {
    public static void sort(int[] array) {
        // Crea una variable cuyo valor es igual a la lolngitud del array
        int n = array.length;
        // Recorre el array para comparar elementos adyacentes y ordenarlos de menor a mayor
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //Si el elemento actual es mayor que el siguiente, se intercambian
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}