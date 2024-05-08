import java.util.Scanner;

public class InsertionSort {
    public static void sort(int[] array) {
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            System.out.println("El elemento actual en la posición " + i + " es: " + current);
            while (j >= 0 && array[j] > current) {
                System.out.println("Se desplaza el elemento " + array[j] + " hacia la derecha");
                array[j + 1] = array[j]; 
                j--;
                scanner.nextLine();
            }
            array[j + 1] = current;
            System.out.println("Se inserta el elemento " + current + " en la posición " + (j + 1));
            scanner.nextLine();
        }
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        sort(data);
        System.out.println("Array ordenado:");
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
