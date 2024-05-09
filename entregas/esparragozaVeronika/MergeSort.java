package entregas.esparragozaVeronika;

public class MergeSort {

    // Método para dividir y fusionar el array
    public static void sort(int[] array, int left, int right) {
        System.out.println("\u001B[37m" + "Dividiendo el array en dos mitades" + "\u001B[0m");
        if (left < right) {
            // Encuentra el punto medio del vector.
            int middle = (left + right) / 2;

            // Divide la primera y segunda mitad (llamada recursiva).
            sort(array, left, middle);
            sort(array, middle + 1, right);

            // Une las mitades.
            merge(array, left, middle, right);
        }
    }

    // Método para fusionar las dos mitades.
    private static void merge(int[] array, int left, int middle, int right) {
        // Tamaños de los subarrays temporales.
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Subarrays temporales.
        System.out.println("Creando arrays temporales");
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia los datos a los arrays temporales.
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        //System.out.println("Array temporal L:");
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];
        }

        // Índices iniciales de los subarrays.
        int i = 0, j = 0;


        // Índice inicial del subarray mezclado
        int k = left;

        // Ordenamiento y mezcla.
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                array[k] = L[i];
                i++;
            } else {
                array[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de L, si los hay.
        while (i < n1) {
            array[k] = L[i];
            i++;
            k++;

            for (int value : array) {
                System.out.print("\u001B[35m" + value + "\u001B[0m ");
            }
            System.out.println(" ");
        }

        // Copiar los elementos restantes de R, si los hay.
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;

            for (int value : array) {
                System.out.print("\033[38;5;220m" + value + "\u001B[0m ");
            }
        }
    }

    public static void main(String[] args) {
        int[] data = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Array original:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        sort(data, 0, data.length - 1);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}