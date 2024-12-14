public class QuickSort {
    // Método para realizar el ordenamiento
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            // Particiona el arreglo y obtiene el índice del pivote en su posición correcta
            int pivotIndex = partition(array, low, high);

            // Ordena recursivamente los elementos antes y después de la partición
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    // Método para particionar el arreglo
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];  // Elige el último elemento como pivote
        int i = (low - 1);  // Índice de menor elemento

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor que el pivote
            if (array[j] < pivot) {
                i++;

                // Intercambia arr[i] y arr[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Intercambia el elemento pivote con el elemento en la posición i+1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;  // Devuelve el índice del pivote
    }

    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        sort(data, 0, data.length - 1);
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
/*
Trazabilidad del Código:

1. Llamada Inicial al Método `sort`:
   - `low = 0`, `high = 5` (longitud del arreglo - 1)
   - Elige el último elemento (`5`) como pivote.
   - Llama al método `partition(array, 0, 5)` para particionar el arreglo.

2. Partición del Arreglo (`partition`):
   - `pivot = 5`, `i = -1` (índice del menor elemento inicializado)

   Iteración del bucle `for (int j = low; j < high; j++)`:
   - `j = 0`: `array[0] = 10` (Mayor que `pivot`): No se realiza intercambio.
   - `j = 1`: `array[1] = 7` (Menor que `pivot`): Incrementa `i` y intercambia `array[1]` con `array[0]`.
   - Después del intercambio: `{7, 10, 8, 9, 1, 5}`

   - `j = 2`: `array[2] = 8` (Mayor que `pivot`): No se realiza intercambio.
   - `j = 3`: `array[3] = 9` (Mayor que `pivot`): No se realiza intercambio.
   - `j = 4`: `array[4] = 1` (Menor que `pivot`): Incrementa `i` y intercambia `array[4]` con `array[2]`.
   - Después del intercambio: `{7, 1, 8, 9, 10, 5}`

   - `j = 5`: `array[5] = 5` (Menor que `pivot`): Incrementa `i` y intercambia `array[5]` con `array[3]`.
   - Después del intercambio: `{7, 1, 5, 9, 10, 8}`

   - Finalmente, intercambia el pivote (`5`) con el elemento en `i + 1` (`array[2]`).
   - Después del intercambio: `{7, 1, 5, 9, 10, 8}` (Arreglo parcialmente ordenado alrededor del pivote).

3. Llamadas Recursivas:
   - `sort(array, 0, 1)`: Llama recursivamente al método para la parte izquierda `{7, 1}`.
   - `sort(array, 3, 5)`: Llama recursivamente al método para la parte derecha `{9, 10, 8}`.

4. Resultado Final:
   - Después de todas las llamadas recursivas y particiones, el arreglo queda completamente ordenado.

    Resultado Final:
Después de que el algoritmo QuickSort complete todas las particiones y llamadas recursivas, el arreglo queda completamente ordenado.

Array ordenado:
1 5 7 8 9 10
 */