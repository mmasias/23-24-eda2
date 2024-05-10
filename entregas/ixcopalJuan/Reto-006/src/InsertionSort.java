public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            System.out.println("\nValor actual a insertar: " + current);
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];  // Desplaza el elemento hacia la derecha
                j--;
                // Imprimir el estado actual del arreglo después de cada desplazamiento
                System.out.print("Desplazando: ");
                for (int k = 0; k <= i; k++) {
                    System.out.print(array[k] + " ");
                }
                System.out.print("\n");
            }
            array[j + 1] = current; // Inserta el elemento en su lugar correcto
            // Imprimir el estado final del arreglo después de insertar el elemento
            System.out.print("Insertado " + current + ": ");
            for (int k = 0; k <= i; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.print("\n");
        }
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        System.out.println("Array original:");
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.print("\n");
        sort(data);
        System.out.println("Array ordenado:");
        for (int value : data) {
            System.out.print(value + " ");
        }
    }
}
