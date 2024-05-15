public class HeapSort {
    public static void sort(int array[]) {
        int n = array.length;

        // Construir el montículo (reorganizar el arreglo)
        System.out.println("Construyendo el montículo:");
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
            System.out.println("Después de heapify en el índice " + i + ": " + printArray(array));
        }

        // Uno por uno extraer un elemento del montículo
        for (int i = n - 1; i > 0; i--) {
            System.out.println("Intercambiando la raíz " + array[0] + " con el elemento " + array[i] + ":");
            // Mover la raíz actual al final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            System.out.println(printArray(array));

            // llamar a la función de reducción del montículo en el montículo reducido
            heapify(array, i, 0);
            System.out.println("Después de heapify en el índice 0: " + printArray(array));
        }
    }

    // Para convertir un subarreglo en un montículo
    static void heapify(int array[], int n, int i) {
        int largest = i; // Inicializar largest como raíz
        int l = 2 * i + 1; // izquierda = 2*i + 1
        int r = 2 * i + 2; // derecha = 2*i + 2

        // Si el hijo izquierdo es mayor que la raíz
        if (l < n && array[l] > array[largest])
            largest = l;

        // Si el hijo derecho es mayor que largest hasta ahora
        if (r < n && array[r] > array[largest])
            largest = r;

        // Si largest no es la raíz
        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            // Recursivamente heapificar el subárbol afectado
            heapify(array, n, largest);
        }
    }

    // Método auxiliar para imprimir el array
    private static String printArray(int[] array) {
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
        int array[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Array inicial: " + printArray(array));
        sort(array);
        System.out.println("Array ordenado: " + printArray(array));
    }
}
