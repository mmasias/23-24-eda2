public class RadixSort {
   
    static int findMax(int array[]) {
        int max = array[0]; 
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i]; 
            }
        }
        return max; 
    }

   
    public static void radixSort(int array[]) {
       
        System.out.println("Array original:");
        printArray(array);

        
        int max = findMax(array);
        System.out.println("\nMáximo encontrado: " + max);

        int exp = 1;

        while (max / exp > 0) {
            System.out.println("\nIteración para el dígito " + exp + ":");

            int count[] = new int[10]; 
            for (int i = 0; i < array.length; i++) {
                count[(array[i] / exp) % 10]++;
            }

            for (int i = 1; i < 10; i++) {
                count[i] += count[i - 1];
            }

            int output[] = new int[array.length]; // Arreglo de salida
            for (int i = array.length - 1; i >= 0; i--) {
                output[count[(array[i] / exp) % 10] - 1] = array[i];
                count[(array[i] / exp) % 10]--;
            }

            for (int i = 0; i < array.length; i++) {
                array[i] = output[i];
            }

            System.out.print("Arreglo después de la iteración: ");
            printArray(array);

            exp *= 10;
        }

        System.out.println("\nArreglo ordenado:");
        printArray(array);
    }

    static void printArray(int array[]) {
        int n = array.length;
        System.out.print("[");
        for (int i = 0; i < n; ++i) {
            System.out.print(array[i]);
            if (i != n - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] data = {1234, 4321, 5678, 9876, 3456};
        radixSort(data);
    }
}
