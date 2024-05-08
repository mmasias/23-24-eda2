public class HeapSort {
    public static void sort(int array[]) {
        int n = array.length;

        System.out.println("Traza:");
        System.out.println("Paso 0: Se inicia con el arreglo original.");
        System.out.println("Arreglo original: " + arrayToString(array));

        // Paso 1: Construir el montículo (reorganizar el arreglo)
        buildMaxHeap(array, n);

        // Paso 2-7: Uno por uno extraer un elemento del montículo
        for (int i = n - 1; i > 0; i--) {
            System.out.println("Paso " + (n - i) + "-" + (n - i + 1) + ":");
            // Paso 2: Intercambiar la raíz actual con el último elemento del montículo
            swap(array, 0, i);
            System.out.println("Arreglo después de extraer el mayor elemento: " + arrayToString(array));
            // Paso 3: Llamar a la función de reducción del montículo en el montículo reducido
            heapify(array, i, 0);
            System.out.println("Montículo después de reorganizar: " + arrayToString(array));
        }
    }

    // Método para construir un montículo máximo
    static void buildMaxHeap(int array[], int n) {
        System.out.println("Paso 1: El montículo se construye a partir del arreglo.");
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
        }
        System.out.println("Montículo construido: " + arrayToString(array));
    }

    // Método para convertir un subarreglo en un montículo
    static void heapify(int array[], int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // Si el hijo izquierdo es mayor que la raíz
        if (l < n && array[l] > array[largest])
            largest = l;

        // Si el hijo derecho es mayor que largest hasta ahora
        if (r < n && array[r] > array[largest])
            largest = r;

        // Si largest no es la raíz
        if (largest != i) {
            swap(array, i, largest);
            // Recursivamente heapificar el subárbol afectado
            heapify(array, n, largest);
        }
    }

    // Método para intercambiar dos elementos en el arreglo
    static void swap(int array[], int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Método para convertir un arreglo en una cadena de texto
    static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("[");
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
        sort(array);
        System.out.println("Array ordenado:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
