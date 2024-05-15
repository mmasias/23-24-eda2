  public static void sort(int[] array, int left, int right) {
        if (left < right) {
            // Encuentra el punto medio del vector.
            int middle = (left + right) / 2;

            // Divide la primera y segunda mitad (llamada recursiva).
            System.out.println("Dividiendo: " + printArray(array, left, right));
            sort(array, left, middle);
            sort(array, middle + 1, right);

            // Une las mitades.
            merge(array, left, middle, right);
            System.out.println("Fusionando: " + printArray(array, left, right));
        }
    }

    // Método para fusionar las dos mitades.
    private static void merge(int[] array, int left, int middle, int right) {
        // Tamaños de los subarrays temporales.
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Subarrays temporales.
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia los datos a los arrays temporales.
        for (int i = 0; i < n1; i++) {
            L[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = array[middle + 1 + j];
        }

        // Índices iniciales de los subarrays.
        int i = 0, j = 0;

        // Índice inicial del subarray mezclado.
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
        }

        // Copiar los elementos restantes de R, si los hay.
        while (j < n2) {
            array[k] = R[j];
            j++;
            k++;
        }
    }

    // Método auxiliar para imprimir un subarray
    private static String printArray(int[] array, int left, int right) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = left; i <= right; i++) {
            sb.append(array[i]);
            if (i < right) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] data = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Array original: " + printArray(data, 0, data.length - 1));
        sort(data, 0, data.length - 1);
        System.out.println("Array ordenado: " + printArray(data, 0, data.length - 1));
    }
}
