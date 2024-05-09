public class HeapSort {
    public static void sort(int array[]) {
        int n = array.length;

        // Construir el montículo (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--) {
            System.out.println("Construyendo heap desde el índice " + i);
            heapify(array, n, i);
            printArray(array);
        }

        // Uno por uno extraer un elemento del montículo
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            System.out.println("Después de mover la raíz al final:");
            printArray(array);

            // llamar a la función de reducción del montículo en el montículo reducido
            heapify(array, i, 0);
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

            System.out.println("Heapify llamado desde índice " + i + " -> Nuevo heap:");
            printArray(array);

            // Recursivamente heapificar el subárbol afectado
            heapify(array, n, largest);
        }
    }

    private static void printArray(int[] array) {
        System.out.print("Array actual: ");
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int array[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Array original:");
        printArray(array);
        sort(array);
        System.out.println("Array ordenado:");
        printArray(array);
    }
}
