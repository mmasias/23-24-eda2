package src;

public class BubbleSort {

    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) { // i es el número de pasadas completas
            for (int j = 0; j < n - 1; j++) { // j es el índice para comparar elementos adyacentes
                if (array[j] > array[j + 1]) {
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            mostrarArray(array);
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        mostrarArray(data);
        sort2(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }


    public static void sort1(int[] array) {
        boolean sorted = false;
        int passIndex = 0; // Para reducir el alcance del barrido en cada pasada
        while (!sorted) {
            sorted = true; // Se asume que el arreglo está ordenado
            for (int j = 0; j < array.length - 1 - passIndex; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sorted = false; // Se encontró un desorden, se continua
                }
            }
            passIndex++;
            System.out.println("Paso " + passIndex + ":" );
            mostrarArray(array);
        }
    }




    public static void sort2(int[] array) {
        boolean swapped;
        int passIndex = 0;
        do {
            swapped = false;
            for (int j = 0; j < array.length - 1 - passIndex; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true; // Se registró un intercambio
                }
            }
            passIndex++;
            System.out.println("Paso " + passIndex + ":" );
            mostrarArray(array);
        } while (swapped); // Continuar mientras se realicen intercambios
    }

    public static void mostrarArray(int[] array) {
        for (int i : array) {

            System.out.print(i + " ");
        }
        System.out.println();
    }


    /*
1. **sort(int[] array)**:
   - Este método implementa el algoritmo de ordenamiento Burbuja utilizando dos bucles `for`. El bucle externo (`i`) controla el número de pasadas completas a través del array, mientras que el bucle interno (`j`) compara elementos adyacentes y realiza intercambios si es necesario.
   - Después de cada pasada completa, se llama al método `mostrarArray(array)` para imprimir el estado actual del array.
2. **main(String[] args)**:
   - En el método `main`, se crea un array de números desordenados.
   - Luego se llama al método `mostrarArray(data)` para mostrar el array inicial.
   - A continuación, se llama al método `sort2(data)` para ordenar el array utilizando el segundo enfoque del algoritmo de Burbuja.
   - Finalmente, se imprime el array ordenado.
3. **sort1(int[] array)**:
   - Este método implementa una versión alternativa del algoritmo de Burbuja.
   - Utiliza un bucle `while` en lugar de un bucle `for` y una bandera `sorted` para determinar si el array está ordenado.
   - Después de cada pasada completa, se llama al método `mostrarArray(array)` para imprimir el estado actual del array.
4. **sort2(int[] array)**:
   - Este método también implementa una versión alternativa del algoritmo de Burbuja.
   - Utiliza un bucle `do-while` y una bandera `swapped` para determinar si se realizó algún intercambio en la pasada actual.
   - Después de cada pasada completa, se llama al método `mostrarArray(array)` para imprimir el estado actual del array.
5. **mostrarArray(int[] array)**:
   - Este método simplemente imprime los elementos del array.
Ambas versiones de la implementación Burbuja (`sort1` y `sort2`) tienen la misma lógica general, pero difieren en la estructura del bucle y la forma en que determinan si se han realizado intercambios. */
}