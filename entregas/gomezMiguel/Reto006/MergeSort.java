import java.util.Scanner;

public class MergeSort {
    public static void sort(int[] array, int left, int right) {
        Scanner scanner = new Scanner(System.in);
        if (left < right) {
            System.out.print("Se encuentra el punto medio del array: ");
            int middle = (left + right) / 2;
            System.out.println(middle);
            
            System.out.println("Dividiendo la primera mitad (del elemento " + left + " al elemento " + middle + ")");
            sort(array, left, middle);
            System.out.println("Dividiendo la segunda mitad (del elemento " + (middle + 1) + " al elemento " + right + ")");
            sort(array, middle + 1, right);

            System.out.println("Se unen las mitades");
            merge(array, left, middle, right);
            scanner.nextLine(); 
        }
    }

    private static void merge(int[] array, int left, int middle, int right) {
        
        int n1 = middle - left + 1;
        int n2 = right - middle;

        int[] L = new int[n1];
        int[] R = new int[n2];

        System.out.println("Se copían los datos a las dos mitades");
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];
        }

        int i = 0, j = 0;

        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }

        System.out.println("Así quedó el array");
        for (int l : array) {
            System.out.print(l + " ");
        }
    }

    public static void main(String[] args) {
        int[] data = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Array original:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        sort(data, 0, data.length - 1);
        System.out.println("\nArray ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
