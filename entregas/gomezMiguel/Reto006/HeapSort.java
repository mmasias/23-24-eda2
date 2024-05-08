import java.util.Scanner;

public class HeapSort {
    public static void sort(int array[]) {
        Scanner scanner = new Scanner(System.in);
        int n = array.length;

        // Construir el montículo (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--) {
            System.out.println("Reorganizando el subárbol con raíz en el índice " + i);
            heapify(array, n, i);
            scanner.nextLine();
        }

        
        for (int i = n - 1; i > 0; i--) {
            
            System.out.println("Moviendo la raíz actual al final");
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            
            System.out.println("Reorganizando el subárbol con raíz en el índice 0");
            heapify(array, i, 0);
            scanner.nextLine();
        }
    }

    
    static void heapify(int array[], int n, int i) {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 

        // Si el hijo izquierdo es mayor que la raíz
        if (l < n && array[l] > array[largest])
            largest = l;

        // Si el hijo derecho es mayor que largest hasta ahora
        if (r < n && array[r] > array[largest])
            largest = r;

        // Si largest no es la raíz
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int array[] = {12, 11, 13, 5, 6, 7};
        sort(array);
        System.out.println("Array ordenado:");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
