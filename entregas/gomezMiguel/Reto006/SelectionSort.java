import java.util.Scanner;
public class SelectionSort {
    public static void sort(int[] array) {
        Scanner scanner = new Scanner(System.in);
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            int minIndex = startIndex;
            System.out.println("Se recorre el array en busca del elemento más pequeño");
            for (int j = startIndex + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    System.out.println("Se encontró que el elemento del índice "+ j + " : " + array[j] + " es menor que el elemento del índice "+ minIndex + " : " + array[minIndex]);
                    minIndex = j; // Encuentra el índice del elemento más pequeño
                } else {
                    System.out.println("El elemento del índice " + j + " es mayor que el actual mínimo que es el elemento del índice " + minIndex);
                }
                scanner.nextLine();
            }
            System.out.println("Se procede a intercambiar las posiciones del elemento mínimo " + minIndex + " : " + array[minIndex] + " y el elemento en la posición " + startIndex + " : " + array[startIndex]);
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;
            startIndex++;
            System.out.println("Se avanza un índice");
        }
    }

    public static void main(String[] args) {
        int[] data = {29, 20, 73, 34, 64};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
