import java.util.Scanner;

public class BubbleSort {
    public static void sort(int[] array) {
        Scanner scanner = new Scanner(System.in);
        boolean swapped = false;
        int passIndex = 0;
        do {
            if (swapped){
                System.out.println("Se buscan más posibles modificaciones");
            }
            swapped = false;
            for (int j = 0; j < array.length - 1 - passIndex; j++) {
                if (array[j] > array[j + 1]) {
                    System.out.println("Se encuentra un posible cambio de los items: " + array[j] + " y " + array[j+1]);
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                    System.out.println("Se realiza y registra el cambio de los items");
                    scanner.nextLine();
                }
            }
            if(!swapped){
                System.out.println("No se encontraron más cambios");
            } else {
                System.out.println("Se avanza un índice");
            }
            passIndex++;
            scanner.nextLine();
        } while (swapped); 
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}