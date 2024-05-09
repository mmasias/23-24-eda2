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
}
/*
Trazabilidad del Algoritmo:

1. Inicio del bucle con `startIndex = 0`:
   - `minIndex` inicialmente se establece como `0`.
   - Encuentra `array[1] (20)` como el menor elemento, actualiza `minIndex` a `1`.
   - Intercambia `array[1] (20)` con `array[startIndex] (29)`.
   - Después del intercambio: `{20, 29, 73, 34, 64}`.

2. Incremento de `startIndex` a `1`:
   - `minIndex` se reinicia como `1`.
   - Encuentra `array[2] (73)` como el menor elemento, no se realiza intercambio.
   - Después de esta iteración: `{20, 29, 73, 34, 64}`.

3. Incremento de `startIndex` a `2`:
   - `minIndex` se reinicia como `2`.
   - Encuentra `array[3] (34)` como el menor elemento, intercambia con `array[startIndex] (73)`.
   - Después del intercambio: `{20, 29, 34, 73, 64}`.

4. Incremento de `startIndex` a `3`:
   - `minIndex` se reinicia como `3`.
   - Encuentra `array[4] (64)` como el menor elemento, intercambia con `array[startIndex] (73)`.
   - Después del intercambio: `{20, 29, 34, 64, 73}`.

5. Incremento de `startIndex` a `4`:
   - `minIndex` se reinicia como `4`.
   - No hay más elementos para comparar, finaliza el proceso.

 Resultado Final:
Después de que el algoritmo Selection Sort complete todas las iteraciones, el arreglo queda completamente ordenado.

// Array ordenado: 20 29 34 64 73*/