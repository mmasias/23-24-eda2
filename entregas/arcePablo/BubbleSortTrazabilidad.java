import java.util.Arrays;

public class BubbleSortTrazabilidad {
    public static void sort(int[] array) throws InterruptedException {
        boolean swapped;
        int passIndex = 0;
        do {
            swapped = false;
            System.out.println("Inicio de la pasada " + (passIndex + 1));
            for (int j = 0; j < array.length - 1 - passIndex; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true; // Se registró un intercambio
                    System.out.println("Intercambio: " + array[j] + " <-> " + array[j + 1]);
                    Thread.sleep(500);
                }
            }
            passIndex++;
            System.out.println("Estado del array después de la pasada " + passIndex + ": " + Arrays.toString(array));
        } while (swapped); // Continuar mientras se realicen intercambios
    }

    public static void main(String[] args) throws InterruptedException {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original:");
        System.out.println(Arrays.toString(data));
        
        sort(data);
        
        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(data));
    }
}
