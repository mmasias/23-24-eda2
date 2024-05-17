public class InsertionSort {
    
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            System.out.println("Insertando el valor: " + current);
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j]; // Desplaza el elemento hacia la derecha
                System.out.println("Desplazando " + array[j] + " de la posición " + j + " a la posición " + (j + 1));
                j--;
            }
            array[j + 1] = current; // Inserta el elemento en su posición correcta
            System.out.println("Insertado en la posición " + (j + 1));
            // Mostrar el estado del arreglo después de la inserción
            System.out.print("Estado del arreglo después de la inserción: ");
            for (int k : array) {
                System.out.print(k + " ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        int[] data = { 22, 11, 99, 88, 9, 7, 42 };
        System.out.println("Array original:");
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println("\nComenzando ordenamiento por inserción:");
        sort(data);
        System.out.println("Array ordenado:");
        for (int value : data) {
            System.out.print(value + " ");
        }
    }
}
