public class MergeSort {

    // Método para dividir y fusionar el array
    public static void sort(int[] array, int left, int right) {
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

    public static void main(String[] args) {
        int[] data = { 12, 11, 13, 5, 6, 7 };
        System.out.println("Array original:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        sort(data, 0, data.length - 1);
        System.out.println("\nArray ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }

    /*

1. **sort(int[] array, int left, int right)**:
   - Este método implementa el algoritmo de ordenamiento Merge Sort.
   - Recibe el array a ordenar, junto con los índices izquierdo (`left`) y derecho (`right`) que delimitan la sección del array que se está ordenando.
   - Si el índice izquierdo es menor que el derecho, lo que significa que hay más de un elemento en la sección del array, se divide el array en dos mitades y se llama recursivamente al método `sort()` para cada mitad.
   - Después de que las mitades izquierda y derecha estén ordenadas, se llama al método `merge()` para fusionarlas en una sola sección ordenada.

2. **merge(int[] array, int left, int middle, int right)**:
   - Este método fusiona dos subarrays ordenados en un único array ordenado.
   - Calcula los tamaños de los subarrays temporales (`L` y `R`).
   - Crea dos subarrays temporales y copia los elementos correspondientes del array original a estos subarrays.
   - Luego, compara los elementos de `L` y `R` uno por uno y los fusiona en el array original en orden ascendente.
   - Finalmente, copia cualquier elemento restante en `L` o `R` al array original.

3. **main(String[] args)**:
   - En el método `main`, se inicializa un array de números desordenados.
   - Se imprime el array original.
   - Se llama al método `sort(data, 0, data.length - 1)` para ordenar el array utilizando el algoritmo de Merge Sort.
   - Finalmente, se imprime el array ordenado.

 */
}