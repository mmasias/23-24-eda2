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

    /*
1. **sort(int[] array, int low, int high)**:
   - Este método implementa el algoritmo de ordenamiento Quick Sort.
   - Recibe el array a ordenar, junto con los índices `low` y `high`, que indican el rango de elementos que se deben ordenar.
   - Si `low` es menor que `high`, lo que indica que hay más de un elemento en el rango, se llama a `partition()` para particionar el array y obtener el índice del pivote en su posición correcta.
   - Luego, se realiza una llamada recursiva a `sort()` para ordenar los elementos antes y después del pivote.

2. **partition(int[] array, int low, int high)**:
   - Este método particiona el array en dos subarrays alrededor de un pivote seleccionado.
   - Elige el último elemento del array como pivote.
   - Inicializa un índice `i` que apunta al elemento más pequeño (inicialmente `low - 1`).
   - Recorre el array desde `low` hasta `high - 1`. Si encuentra un elemento menor que el pivote, incrementa `i` y intercambia `array[i]` con `array[j]`.
   - Finalmente, intercambia el pivote con el elemento en la posición `i + 1` para colocar el pivote en su posición correcta y devuelve este índice.

3. **main(String[] args)**:
   - En el método `main`, se inicializa un array de números desordenados.
   - Se llama al método `sort(data, 0, data.length - 1)` para ordenar el array utilizando el algoritmo de Quick Sort.
   - Finalmente, se imprime el array ordenado.
*/
}