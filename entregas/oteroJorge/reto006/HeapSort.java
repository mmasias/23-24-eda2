package entregas.oteroJorge.reto006;

public class HeapSort {
    public static void sort(int array[]) {
        int n = array.length;

        System.out.println("Construyendo el montículo inicial:");
        printArray(array);

        // Construir el montículo (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
            System.out.println("Paso " + (n / 2 - i) + ": Reorganización del montículo");
            printArray(array);
        }

        // Uno por uno extraer un elemento del montículo
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            System.out.println("Extrayendo elemento " + temp + " del montículo");
            printArray(array);

            // Llamar a la función de reducción del montículo en el montículo reducido
            heapify(array, i, 0);
            System.out.println("Reorganización del montículo después de extraer el elemento");
            printArray(array);
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

    // Método para imprimir el array en la consola
    public static void printArray(int[] array) {
        System.out.print("Estado actual del array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int array[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Array original:");
        printArray(array);

        sort(array);

        System.out.println("\nArray ordenado:");
        printArray(array);
    }
}

