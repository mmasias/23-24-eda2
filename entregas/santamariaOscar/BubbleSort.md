# Algoritmo de Ordenamiento de Burbuja (Bubble Sort)

Este repositorio contiene una implementación en Java del algoritmo de ordenamiento de burbuja.

## Descripción del Algoritmo

El algoritmo de ordenamiento de burbuja es un algoritmo simple pero ineficiente que funciona recorriendo repetidamente la lista de elementos que se desea ordenar, comparando elementos adyacentes y realizando intercambios si están en el orden incorrecto. Este proceso se repite hasta que no se requieren más intercambios, lo que indica que la lista está ordenada.

La idea principal detrás del algoritmo de burbuja es "flotar" los elementos más grandes hacia el final de la lista, similar a cómo suben las burbujas en un líquido, de ahí su nombre. En cada pasada a través de la lista, el algoritmo compara pares de elementos adyacentes y los intercambia si están en el orden incorrecto. Este proceso se repite hasta que ningún intercambio es necesario, lo que significa que la lista está ordenada.

A pesar de su simplicidad, el algoritmo de burbuja es muy ineficiente para listas grandes, ya que requiere múltiples pasadas completas a través de la lista, incluso si la lista ya está ordenada. Su complejidad computacional es de O(n^2), donde n es el número de elementos en la lista.

## Código Fuente
```java
public class BubbleSort {
    /**
     * Ordena un array de enteros utilizando el algoritmo de ordenamiento de burbuja.
     * @param array El array de enteros a ordenar.
     */
    public static void sort(int[] array) {
        boolean swapped; // Variable para rastrear si se ha realizado algún intercambio
        int passIndex = 0; // Variable para rastrear el número de pases a través del array
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
        } while (swapped); // Continuar mientras se realicen intercambios
    }

    /**
     * Método principal para probar el algoritmo de ordenamiento de burbuja.
     * @param args Los argumentos de la línea de comandos (no se utilizan).
     */
    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
java´´´
ç

## Trazabilidad del Código

El código proporcionado en `BubbleSort.java` implementa el algoritmo de ordenamiento de burbuja en Java. Aquí está la trazabilidad del código:

1. **Método `sort`**:
   - Este método ordena un array de enteros utilizando el algoritmo de ordenamiento de burbuja.
   - Utiliza un bucle `do-while` para repetir el proceso de ordenamiento hasta que no se requieran más intercambios.
   - Dentro del bucle, utiliza un bucle `for` para comparar pares de elementos adyacentes y realizar intercambios si es necesario.

2. **Método `main`**:
   - Este método es el punto de entrada del programa.
   - Crea un array de enteros desordenado.
   - Llama al método `sort` para ordenar el array.
   - Imprime el array ordenado en la consola.

