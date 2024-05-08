import java.util.Arrays;

public class SelectionSort {
    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Encuentra el índice del elemento más pequeño
                }
            }
            int temp = array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;

            System.out.println("Iteración " + (i + 1) + ": " + Arrays.toString(array));
        }
    }

    public static void main(String[] args) {
        int[] data = {29, 20, 73, 34, 64};
        System.out.println("Array original: " + Arrays.toString(data));
        sort(data);
        System.out.println("Array ordenado:");
        System.out.println(Arrays.toString(data));
    }
}
//
1. **Paso 1:**
   - Selecciona el elemento más pequeño de la sublista no ordenada ([20, 73, 34, 64]) y lo intercambia con el primer elemento del arreglo.
     - Elemento más pequeño: 20 (en el índice 1)
     - Intercambio: [20, 29, 73, 34, 64]

2. **Paso 2:**
   - Selecciona el elemento más pequeño de la sublista no ordenada ([29, 73, 34, 64]) y lo intercambia con el segundo elemento del arreglo.
     - Elemento más pequeño: 29 (en el índice 0)
     - Intercambio: [20, 29, 73, 34, 64]

3. **Paso 3:**
   - Selecciona el elemento más pequeño de la sublista no ordenada ([73, 34, 64]) y lo intercambia con el tercer elemento del arreglo.
     - Elemento más pequeño: 34 (en el índice 2)
     - Intercambio: [20, 29, 34, 73, 64]

4. **Paso 4:**
   - Selecciona el elemento más pequeño de la sublista no ordenada ([73, 64]) y lo intercambia con el cuarto elemento del arreglo.
     - Elemento más pequeño: 64 (en el índice 3)
     - Intercambio: [20, 29, 34, 64, 73]

5. **Paso 5:**
   - Selecciona el elemento más pequeño de la sublista no ordenada ([73]) y lo intercambia con el último elemento del arreglo.
     - Elemento más pequeño: 73 (en el índice 4)
     - Intercambio: [20, 29, 34, 64, 73]
//
