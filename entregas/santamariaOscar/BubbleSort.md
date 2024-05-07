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
```

## Trazabilidad del Código


Lista original: ([64, 34, 25, 12, 22, 11, 90])

**Pase 1:**
- Comparando 64 con 34: Intercambio
- Comparando 64 con 25: Intercambio
- Comparando 64 con 12: Intercambio
- Comparando 64 con 22: Intercambio
- Comparando 64 con 11: Intercambio
- Comparando 64 con 90: No hay intercambio
- Lista actualizada: ([34, 25, 12, 22, 11, 64, 90])

**Pase 2:**
- Comparando 34 con 25: Intercambio
- Comparando 34 con 12: Intercambio
- Comparando 34 con 22: Intercambio
- Comparando 34 con 11: Intercambio
- Comparando 34 con 64: No hay intercambio
- Comparando 64 con 90: No hay intercambio
- Lista actualizada: ([25, 12, 22, 11, 34, 64, 90])

**Pase 3:**
- Comparando 25 con 12: Intercambio
- Comparando 25 con 22: Intercambio
- Comparando 25 con 11: Intercambio
- Comparando 25 con 34: No hay intercambio
- Comparando 34 con 64: No hay intercambio
- Comparando 64 con 90: No hay intercambio
- Lista actualizada: ([12, 22, 11, 25, 34, 64, 90])

**Pase 4:**
- Comparando 12 con 22: No hay intercambio
- Comparando 22 con 11: Intercambio
- Comparando 22 con 25: No hay intercambio
- Comparando 25 con 34: No hay intercambio
- Comparando 34 con 64: No hay intercambio
- Comparando 64 con 90: No hay intercambio
- Lista actualizada: ([12, 11, 22, 25, 34, 64, 90])

**Pase 5:**
- Comparando 12 con 11: Intercambio
- Comparando 12 con 22: No hay intercambio
- Comparando 22 con 25: No hay intercambio
- Comparando 25 con 34: No hay intercambio
- Comparando 34 con 64: No hay intercambio
- Comparando 64 con 90: No hay intercambio
- Lista actualizada: ([11, 12, 22, 25, 34, 64, 90])

**Pase 6:**
- Comparando 11 con 12: No hay intercambio
- Comparando 12 con 22: No hay intercambio
- Comparando 22 con 25: No hay intercambio
- Comparando 25 con 34: No hay intercambio
- Comparando 34 con 64: No hay intercambio
- Comparando 64 con 90: No hay intercambio
- Lista actualizada: ([11, 12, 22, 25, 34, 64, 90])

**Lista Final Ordenada: ([11, 12, 22, 25, 34, 64, 90])**
