import java.util.Scanner;

public class CountingSort {
    public void sort(int[] array) {
        Scanner scanner = new Scanner(System.in);
        int length = array.length;
        int output[] = new int[length];

        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        System.out.println("Contando la frecuencia de cada elemento en el array");
        for (int i = 0; i < length; i++) {
            System.out.println("Elemento " + array[i] + ": " + countOccurrences(array, array[i]));
            scanner.nextLine(); 
        }

        int count[] = new int[max + 1];

        for (int i = 0; i < length; i++) {
            count[array[i]]++;
        }

        System.out.println("Calculando las posiciones finales de cada elemento en el array ordenado");
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
            System.out.println("Elemento " + i + " va a estar en la posición " + count[i] + " en el array ordenado");
            scanner.nextLine(); 
        }

        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        System.out.println("Copiando los elementos ordenados al array original");
        for (int i = 0; i < length; i++) {
            array[i] = output[i];
            System.out.println("Copiando " + array[i] + " a la posición " + i + " del array original");
            scanner.nextLine(); 
        }
    }

    private int countOccurrences(int[] array, int element) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == element) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountingSort obj = new CountingSort();
        int[] data = {4, 2, 2, 8, 3, 3, 1};

        System.out.println("Array original:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();

        obj.sort(data);

        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
