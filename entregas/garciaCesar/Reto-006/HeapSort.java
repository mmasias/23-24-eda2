public class HeapSort {

    public static void mostrarArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void sort(int array[]) {
        int n = array.length;

        // Construir el montículo (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);
        System.out.println("Montículo construido:");
        mostrarArray(array); // Mostrar el arreglo después de construir el montículo

        // Uno por uno extraer un elemento del montículo
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // llamar a la función de reducción del montículo en el montículo reducido
            heapify(array, i, 0);
            System.out.println("Paso " + (n - i) + " de ordenamiento:");
            mostrarArray(array); // Mostrar el arreglo después de cada paso de ordenamiento
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

    public static void main(String[] args) {
        int array[] = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Array original:");
        mostrarArray(array); // Mostrar el arreglo original
        sort(array); // Llamar al método sort para ordenar el arreglo
        System.out.println("Array ordenado:");
        mostrarArray(array); // Mostrar el arreglo completamente ordenado
    }
}
/*
Trazabilidad del Algoritmo:

1. Construcción del Montículo Inicial (`heapify` en cada nodo no hoja):
   - Se inicia el proceso de construcción del montículo (heap) con el bucle `for` que llama a `heapify` para cada nodo que no es una hoja. Esto reorganiza el arreglo en una estructura de montículo.
   - Después de la construcción inicial del montículo, el arreglo se ve como: `{13, 11, 12, 5, 6, 7}`.

2. Proceso de Ordenamiento (Extraer elementos del montículo):
   - El siguiente bucle `for` extrae elementos del montículo uno por uno.
   - En cada iteración del bucle:
     - La raíz del montículo (el elemento más grande) se mueve al final del arreglo intercambiándolo con el último elemento no ordenado.
     - Luego, se llama a `heapify` en el subárbol reducido para mantener la propiedad del montículo.
   - Durante este proceso, se muestran los arreglos en cada paso para visualizar cómo cambia el arreglo en cada iteración.

3. Resultado Final (Arreglo Ordenado):
   - Después de que el bucle de ordenamiento completo, el arreglo se muestra como completamente ordenado.
   Array ordenado:
    5 6 7 11 12 13 
*/