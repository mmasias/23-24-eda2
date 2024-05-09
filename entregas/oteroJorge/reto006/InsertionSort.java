package entregas.oteroJorge.reto006;

public class InsertionSort {
    public static void sort(int[] array) {
        System.out.println("Array original: " + arrayToString(array));

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            System.out.println("\nIteración " + i + ": Elemento a insertar = " + current);
            System.out.println("Estado actual del array: " + arrayToString(array));

            while (j >= 0 && array[j] > current) {
                // Desplaza el elemento hacia la derecha
                array[j + 1] = array[j];
                j--;

                System.out.println("Desplazando elemento a la derecha...");
                System.out.println("Nuevo estado del array: " + arrayToString(array));
            }

            // Inserta el elemento en su lugar correcto
            array[j + 1] = current;

            System.out.println("Insertando elemento " + current + " en su posición correcta");
            System.out.println("Estado actual del array: " + arrayToString(array));
        }

        System.out.println("\nArray ordenado: " + arrayToString(array));
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        System.out.println("Iniciando Insertion Sort...");
        sort(data);
    }
}
