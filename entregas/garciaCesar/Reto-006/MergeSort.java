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
}
/*
Explicación del Algoritmo Merge Sort:

El algoritmo Merge Sort es un algoritmo de dividir y conquistar que divide repetidamente una lista en dos mitades, ordena cada mitad de forma recursiva y luego combina las dos mitades ordenadas para obtener la lista ordenada completa.

    Trazabilidad del Código:

1. Llamada Inicial al Método `sort`:
   - `left = 0`, `right = 5` (longitud del arreglo - 1)
   - Divide el arreglo en dos mitades:
     - Llamada recursiva a `sort(array, 0, 2)` para la primera mitad `{12, 11, 13}`
     - Llamada recursiva a `sort(array, 3, 5)` para la segunda mitad `{5, 6, 7}`

2. División y Llamadas Recursivas:**
   - Primera Mitad `{12, 11, 13}`:
     - `left = 0`, `right = 2`
     - Divide en `{12, 11}` y `{13}`
     - Llamada recursiva a `sort(array, 0, 1)` para `{12, 11}`
       - `left = 0`, `right = 1`
       - Divide en `{12}` y `{11}`
       - Llamada recursiva a `sort(array, 0, 0)` para `{12}` (ya ordenado)
       - Llamada recursiva a `sort(array, 1, 1)` para `{11}` (ya ordenado)
     - Llamada recursiva a `sort(array, 2, 2)` para `{13}` (ya ordenado)

   - Segunda Mitad `{5, 6, 7}`:
     - `left = 3`, `right = 5`
     - Divide en `{5}` y `{6, 7}`
     - Llamada recursiva a `sort(array, 3, 3)` para `{5}` (ya ordenado)
     - Llamada recursiva a `sort(array, 4, 5)` para `{6, 7}`
       - `left = 4`, `right = 5`
       - Divide en `{6}` y `{7}`
       - Llamada recursiva a `sort(array, 4, 4)` para `{6}` (ya ordenado)
       - Llamada recursiva a `sort(array, 5, 5)` para `{7}` (ya ordenado)

3. Combinación y Fusión de Mitades Ordenadas:
   - Fusión de `{12, 11}`: `{11, 12}`
   - Fusión de `{11, 12}` con `{13}`: `{11, 12, 13}`
   - Fusión de `{5}` con `{6}`: `{5, 6}`
   - Fusión de `{5, 6}` con `{7}`: `{5, 6, 7}`
   - Fusión de `{11, 12, 13}` con `{5, 6, 7}`: `{5, 6, 7, 11, 12, 13}`

    Resultado Final:
Después de que el algoritmo Merge Sort complete todas las fusiones, el arreglo queda completamente ordenado.

Array ordenado:
5 6 7 11 12 13
 */