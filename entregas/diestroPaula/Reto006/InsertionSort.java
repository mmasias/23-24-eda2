package entregas.diestroPaula.Reto006;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j]; // Desplaza el elemento hacia la derecha
                j--;
            }
            array[j + 1] = current; // Inserta el elemento en su lugar correcto

            // Imprimir el estado actual del arreglo
            System.out.println("Iteración " + i + ":");
            printArray(array);
        }
    }

    static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = { 22, 11, 99, 88, 9, 7, 42 };
        System.out.println("Array original:");
        printArray(data);
        sort(data);
        System.out.println("\nArray ordenado:");
        printArray(data);
    }
}
