public class HeapSort {
    public static void sort(int array[]) {
        int n = array.length;

        // Construir el montículo (reorganizar el arreglo)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);
        // Uno por uno extraer un elemento del montículo
        for (int i = n - 1; i > 0; i--) {
            // Mover la raíz actual al final
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // llamar a la función de reducción del montículo en el montículo reducido
            heapify(array, i, 0);
            System.out.print("Paso " + (n - i) + ": ");
            mostrarArray(array);
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
        int array[] = {12, 11, 13, 5, 6, 7};
        sort(array);
        System.out.println("Array ordenado:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }

    public static void mostrarArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /*
1. **sort(int array[])**:
   - Este método implementa el algoritmo de Heap Sort.
   - Inicia construyendo un heap máximo (un árbol binario completo donde el valor de cada nodo es mayor o igual que los valores de sus hijos) a partir del array dado.
   - Luego, extrae uno por uno los elementos del heap, lo que en esencia coloca el elemento más grande en la parte final del array.
   - Después de cada extracción, se reorganiza el heap para mantener su estructura de montículo.
   - Durante el proceso de extracción e intercambio, se muestra el estado del array en cada paso llamando a `mostrarArray(array)`.

2. **heapify(int array[], int n, int i)**:
   - Este método se utiliza para convertir un subarreglo en un heap máximo.
   - Se compara el elemento en la posición `i` (raíz del subárbol) con sus hijos izquierdo (`l = 2*i + 1`) y derecho (`r = 2*i + 2`).
   - Si alguno de los hijos es mayor que el nodo actual, se intercambian y se recursivamente heapifica el subárbol afectado.

3. **main(String[] args)**:
   - En el método `main`, se inicializa un array de números desordenados.
   - Se llama al método `sort(array)` para ordenar el array utilizando el algoritmo de Heap Sort.
   - Finalmente, se imprime el array ordenado.

4. **mostrarArray(int[] array)**:
   - Este método imprime los elementos de un array.

 */
}