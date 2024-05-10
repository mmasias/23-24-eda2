import java.util.Arrays;

public class SelectionSortTrazabilidad {
    public static void sort(int[] array) throws InterruptedException {
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            int minIndex = startIndex;
            for (int j = startIndex + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Encuentra el índice del elemento más pequeño
                }
            }
            // Intercambio del elemento mínimo encontrado con el elemento en startIndex
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;
            System.out.println("Estado del array después de la vuelta " + (startIndex + 1) + ": " + Arrays.toString(array));
            Thread.sleep(500);
            startIndex++;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] data = {29, 20, 73, 34, 64};
        System.out.println("Array original:");
        System.out.println(Arrays.toString(data));
        
        sort(data);
        
        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(data));
    }
}
