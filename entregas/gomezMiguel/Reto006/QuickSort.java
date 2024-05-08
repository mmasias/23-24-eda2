import java.util.Scanner;

public class QuickSort {
    
    public static void sort(int[] array, int low, int high) {
        Scanner scanner = new Scanner(System.in);
        if (low < high) {
            
            System.out.println("Particionando el array desde el índice " + low + " hasta " + high);
            int pivotIndex = partition(array, low, high);

            
            System.out.println("Ordenando la mitad izquierda del array");
            sort(array, low, pivotIndex - 1);
            
            System.out.println("Ordenando la mitad derecha del array");
            sort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        Scanner scanner = new Scanner(System.in);
        int pivot = array[high];  
        int i = low - 1; 

        for (int j = low; j < high; j++) {
            
            if (array[j] < pivot) {
                i++;

                System.out.println("El elemento " + array[j] + " es menor que el pivote " + pivot);
                System.out.println("Intercambiando " + array[i] + " y " + array[j]);
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                scanner.nextLine();
            }
            
        }

        
        System.out.println("Moviendo el pivote " + pivot + " a la posición del elemento " + (i+1));
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        scanner.nextLine();

        return i + 1;
    }

    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        sort(data, 0, data.length - 1);
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
