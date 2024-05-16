package reto006;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];  // Desplaza el elemento hacia la derecha
                j--;
            }
            array[j + 1] = current; // Inserta el elemento en su lugar correcto
            if (array[i] != current) {
                System.out.println("Intercambio: " + array[i] + " por " + current);
                for (int n : array) {
                    System.out.print(n + " ");
                }
                System.out.println(); 
            }     
        }
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        System.out.println("Array inicial: ");
        for(int value : data) {
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