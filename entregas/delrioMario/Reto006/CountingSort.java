public class CountingSort {
    public void sort(int[]  array) {
        int length =  array.length;
        // El  arreglo de salida que tendrá los elementos ordenados
        int output[] = new int[length];

        // Encuentra el elemento mayor para saber el rango
        int max =  array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max)
                max =  array[i];
            
        }
        System.out.println("El número mayor es: " + max);
        System.out.println(" ");

        // Arreglo de conteo
        int count[] = new int[max + 1];
        System.out.println("Arreglo de conteo: ");
        // Almacenar el conteo de cada elemento
        for (int i = 0; i < length; i++) {
            count[array[i]]++;
            System.out.print("Paso " + i + ": ");
            mostrarArray(count);
        }

        System.out.println(" \nConteo de elementos: \n");

        // Cambiar count[i] para que count[i] contenga la posición actual
        // de este elemento en output[]
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
            System.out.print("Paso " + i + ": ");
            mostrarArray(count);
        }

        System.out.println(" \nArreglo de salida: \n");
        // Construir el  arreglo de salida
        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
            System.out.print("Paso " + (length - i) + ": ");
            mostrarArray(output);
        }

        // Copiar los elementos ordenados al  arreglo original
        for (int i = 0; i < length; i++) {
             array[i] = output[i];
        }
    }

    public static void main(String[] args) {
        CountingSort obj = new CountingSort();
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        mostrarArray(data);
        obj.sort(data);
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }

    public static void mostrarArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /*
1. **sort(int[] array)**:
   - Este método implementa el algoritmo de Counting Sort.
   - Calcula el número máximo en el array de entrada para determinar el rango de valores.
   - Crea un array de conteo para contar la frecuencia de cada elemento en el array de entrada.
   - Actualiza el array de conteo para que cada elemento `count[i]` contenga la posición actual de ese elemento en el array de salida.
   - Construye el array de salida utilizando el array de conteo.
   - Copia los elementos ordenados del array de salida al array original.

2. **main(String[] args)**:
   - En el método `main`, se crea una instancia de la clase `CountingSort`.
   - Se inicializa un array de números desordenados.
   - Se llama al método `mostrarArray(data)` para mostrar el array inicial.
   - Se llama al método `sort(data)` de la instancia de `CountingSort` para ordenar el array.
   - Finalmente, se imprime el array ordenado.

3. **mostrarArray(int[] array)**:
   - Este método imprime los elementos de un array.

El algoritmo de Counting Sort en sí se divide en tres partes principales:

- **Conteo de frecuencias**:
  - Se recorre el array de entrada y se cuentan las ocurrencias de cada elemento, almacenándolas en un array de conteo.

- **Cálculo de posiciones**:
  - Se modifica el array de conteo para que cada elemento `count[i]` contenga la posición en la que el elemento `i` debería aparecer en el array ordenado.

- **Construcción del array ordenado**:
  - Utilizando el array de conteo, se construye el array ordenado, colocando cada elemento en su posición correcta.*/

}