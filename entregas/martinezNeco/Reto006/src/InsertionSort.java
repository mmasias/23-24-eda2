package src;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];  // Desplaza el elemento hacia la derecha
                j--;
            }
            array[j + 1] = current; // Inserta el elemento en su lugar correcto
        }
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        sort(data);
        System.out.println("Array ordenado:");
        for (int value : data) {
            System.out.print(value + " ");
        }
    }

    /*
1. **sort(int[] array)**:
   - Este método implementa el algoritmo de ordenamiento por inserción.
   - Itera sobre el array, comenzando desde el segundo elemento (`i = 1`).
   - En cada iteración, guarda el valor del elemento actual (`array[i]`) en la variable `current`.
   - Inicia un bucle `while` con el índice `j` apuntando al elemento anterior al elemento actual.
   - Dentro del bucle, se comparan los elementos en las posiciones `j` y `current`. Si `array[j]` es mayor que `current`, se desplaza `array[j]` una posición a la derecha.
   - Después de que se encuentre la posición correcta para `current`, se inserta en esa posición.
   - Este proceso se repite para cada elemento del array, lo que garantiza que el array esté ordenado al final del método.
2. **main(String[] args)**:
   - En el método `main`, se crea un array de números desordenados.
   - Se llama al método `sort(data)` para ordenar el array utilizando el algoritmo de inserción.
   - Finalmente, se imprime el array ordenado.
 */
}
