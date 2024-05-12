import java.util.Scanner;

public class BubbleSort {
    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) { // i es el número de pasadas completas
            System.out.println("Iteracion: " + i + 1);
            for (int j = 0; j < n - 1; j++) { // j es el índice para comparar elementos adyacentes
                System.out.println();
                System.out.println("El array ahora es: ");
                for (int item : array) {
                    System.out.print(item + " ");
                }
                System.out.println();
                System.out.println("Se compararan los valores: " + array[j] + " y " + array[j + 1]);
                if (array[j] > array[j + 1]) {
                    System.out.println(array[j] + " es mayor que " + array[j + 1] + ": Se intercambiaran de posicion");
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                } else {
                    System.out.println(array[j] + " es menor que " + array[j + 1] + ": Se deja igual");
                }
                new Scanner(System.in).nextLine();
            }
        }
    }

    public static void main(String[] args) {
        int[] data = { 64, 34, 25, 12, 22, 11, 90 };
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
