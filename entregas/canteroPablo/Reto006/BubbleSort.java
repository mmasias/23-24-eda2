public class BubbleSort {
    public static void sort(int[] array) {
        int n = array.length;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            System.out.println("Pasada número " + (i + 1));
            
            for (int j = 0; j < n - 1 - i; j++) {
                int current = array[j];
                int next = array[j + 1];
                System.out.println("Comparando: " + current + " y " + next);
                
                if (current > next) {
                    System.out.println("Intercambiando: " + current + " con " + next);
                    swap(array, j, j + 1);
                    swapped = true;
                }
            }
            
            if (!swapped) {
                break;
            }
            
            printArrayState(array, i + 1);
        }
    }
    
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private static void printArrayState(int[] array, int pass) {
        System.out.print("Estado del array después de la pasada " + pass + ": ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original:");
        printArray(data);
        
        System.out.println("\nComenzando el ordenamiento...");
        sort(data);
        
        System.out.println("Array ordenado:");
        printArray(data);
    }
    
    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
