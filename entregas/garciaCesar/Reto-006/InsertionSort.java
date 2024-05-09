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
}
/*
Trazabilidad del Código:

1. Iteración 1 (i = 1):
   - `current = 11`
   - `j = 0`
   - Comparación: `array[0] > current` (22 > 11)
   - Desplazamiento: `{22, 22, 99, 88, 9, 7, 42}` (Desplaza 22 a la derecha)
   - Arreglo intermedio: `{11, 22, 99, 88, 9, 7, 42}`

2. Iteración 2 (i = 2):
   - `current = 99`
   - `j = 1`
   - Comparación: `array[1] > current` (22 < 99)
   - No se realiza desplazamiento
   - Arreglo intermedio: `{11, 22, 99, 88, 9, 7, 42}`

3. Iteración 3 (i = 3):
   - `current = 88`
   - `j = 2`
   - Comparación: `array[2] > current` (99 > 88)
   - Desplazamiento: `{11, 22, 99, 99, 9, 7, 42}` (Desplaza 99 a la derecha)
   - Arreglo intermedio: `{11, 22, 88, 99, 9, 7, 42}`

4. Iteración 4 (i = 4):
   - `current = 9`
   - `j = 3`
   - Comparación: `array[3] > current` (99 > 9)
   - Desplazamiento: `{11, 22, 88, 99, 99, 7, 42}` (Desplaza 99 a la derecha)
   - Comparación: `array[2] > current` (88 > 9)
   - Desplazamiento: `{11, 22, 88, 88, 99, 7, 42}` (Desplaza 88 a la derecha)
   - Arreglo intermedio: `{11, 22, 88, 9, 99, 7, 42}`

5. Iteración 5 (i = 5):
   - `current = 7`
   - `j = 4`
   - Comparación: `array[4] > current` (99 > 7)
   - Desplazamiento: `{11, 22, 88, 9, 99, 99, 42}` (Desplaza 99 a la derecha)
   - Comparación: `array[3] > current` (9 > 7)
   - Desplazamiento: `{11, 22, 88, 9, 9, 99, 42}` (Desplaza 9 a la derecha)
   - Comparación: `array[2] > current` (88 > 7)
   - Desplazamiento: `{11, 22, 88, 88, 9, 99, 42}` (Desplaza 88 a la derecha)
   - Comparación: `array[1] > current` (22 > 7)
   - Desplazamiento: `{11, 22, 22, 88, 9, 99, 42}` (Desplaza 22 a la derecha)
   - Arreglo intermedio: `{11, 7, 22, 88, 9, 99, 42}`

6. Iteración 6 (i = 6):
   - `current = 42`
   - `j = 5`
   - Comparación: `array[5] > current` (99 > 42)
   - Desplazamiento: `{11, 7, 22, 88, 9, 99, 99}` (Desplaza 99 a la derecha)
   - Comparación: `array[4] > current` (88 > 42)
   - Desplazamiento: `{11, 7, 22, 88, 88, 99, 99}` (Desplaza 88 a la derecha)
   - Comparación: `array[3] > current` (22 > 42) [No se cumple]
   - Inserta `current` en la posición correcta
   - Arreglo intermedio: `{11, 7, 22, 88, 9, 42, 99}`

   Resultado Final:
Después de que el algoritmo Insertion Sort complete todas las iteraciones, el arreglo queda completamente ordenado.

Array ordenado:
7 9 11 22 42 88 99
*/