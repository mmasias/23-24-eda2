import java.util.Arrays;

public class InsertionSortTrazabilidad {
    public static void sort(int[] array) throws InterruptedException {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];  // Desplaza el elemento hacia la derecha
                j--;
            }
            array[j + 1] = current; // Inserta el elemento en su lugar correcto
            System.out.println("Estado del array después de la iteración " + i + ": " + Arrays.toString(array));
            Thread.sleep(500);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        System.out.println("Array original:");
        System.out.println(Arrays.toString(data));
        
        sort(data);
        
        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(data));
    }
}
