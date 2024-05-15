
public class InsertionSort {
    public static void sort(int[] array) {
        System.out.println("Arreglo inicial: " + java.util.Arrays.toString(array));
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            System.out.print("Iteración " + i + ": ");
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j]; // Desplaza el elemento hacia la derecha
                j--;
            }
            array[j + 1] = current; // Inserta el elemento en su lugar correcto
            System.out.println(java.util.Arrays.toString(array));
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
