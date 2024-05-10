public class HeapSortTrazabilidad {
    public static void sort(int array[]) throws InterruptedException {
        int n = array.length;

        // Construir el montículo (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
            // Imprime el estado del array después de cada paso de construcción del montículo
            System.out.println("Estado del array después de construir el montículo: " + arrayAsString(array));
            Thread.sleep(500);
        }

        // Uno por uno extraer un elemento del montículo
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Llamar a la función de reducción del montículo en el montículo reducido
            heapify(array, i, 0);

            // Imprime el estado del array después de cada intercambio en la etapa de extracción
            System.out.println("Estado del array después de extraer el elemento máximo: " + arrayAsString(array));
            Thread.sleep(500);
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

    // Método auxiliar para imprimir el array como una cadena.
    private static String arrayAsString(int[] array) {
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

    public static void main(String[] args) throws InterruptedException {
        int array[] = {12, 11, 13, 5, 6, 7};
        System.out.println("Array original:");
        System.out.println(arrayAsString(array));
        
        sort(array);
        
        System.out.println("Array ordenado:");
        System.out.println(arrayAsString(array));
    }
}
