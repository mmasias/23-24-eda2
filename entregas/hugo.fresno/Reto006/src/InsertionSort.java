public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            System.out.println("Insertando " + current + " en la posición correcta");
            while (j >= 0 && array[j] > current) {
                System.out.println("Desplazando " + array[j] + " de índice " + j + " a índice " + (j + 1));
                array[j + 1] = array[j];  // Desplaza el elemento hacia la derecha
                j--;
            }
            array[j + 1] = current; // Inserta el elemento en su lugar correcto
            System.out.print("Arreglo después de la inserción: ");
            for (int k = 0; k < array.length; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        System.out.println("Arreglo original:");
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println("\nIniciando el proceso de ordenamiento...");
        sort(data);
        System.out.println("Array ordenado:");
        for (int value : data) {
            System.out.print(value + " ");
        }
    }
}
