public class SelectionSort {
    public static void sort(int[] array) {
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            int minIndex = startIndex;
            for (int j = startIndex + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Encuentra el índice del elemento más pequeño
                }
            }
            // Intercambio del elemento mínimo encontrado con el elemento en startIndex
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;
            startIndex++;
        }
    }

    public static void main(String[] args) {
        int[] data = {29, 20, 73, 34, 64};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }

    /*

1. **sort(int[] array)**:
   - Este método implementa el algoritmo de ordenamiento por selección.
   - Inicia con un índice `startIndex` que señala el primer elemento del array.
   - Mientras `startIndex` sea menor que la longitud del array menos uno, itera sobre el array.
   - En cada iteración, busca el índice del elemento más pequeño en el subarray no ordenado, comenzando desde `startIndex`.
   - Una vez encontrado el índice del elemento más pequeño (`minIndex`), intercambia ese elemento con el elemento en `startIndex`.
   - Incrementa `startIndex` para reducir el tamaño del subarray no ordenado.
   - Este proceso continúa hasta que todos los elementos estén ordenados.

2. **main(String[] args)**:
   - En el método `main`, se inicializa un array de números desordenados.
   - Se llama al método `sort(data)` para ordenar el array utilizando el algoritmo de selección.
   - Finalmente, se imprime el array ordenado.

*/
}