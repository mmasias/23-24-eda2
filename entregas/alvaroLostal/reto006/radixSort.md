# Radix Sort

## ¿Por qué?

El Radix Sort es un algoritmo de ordenamiento que ofrece una complejidad temporal lineal \(O(n)\) para números de dígitos fijos. Esto lo hace especialmente útil en situaciones donde se trabaja con grandes volúmenes de datos y se necesita un rendimiento predecible y rápido. Además, el Radix Sort es estable, lo que significa que mantiene el orden relativo de elementos con valores iguales, lo que lo hace adecuado para datos con múltiples dígitos.

## ¿Qué?

El Radix Sort ordena los elementos dígito por dígito, comenzando por el menos significativo y avanzando hacia el más significativo. En cada iteración, los elementos se agrupan en contenedores según el valor del dígito actual, y luego se reconstruye el arreglo a partir de estos contenedores. Este proceso se repite hasta que se han procesado todos los dígitos.

## ¿Para qué?

El Radix Sort es particularmente útil cuando se trabaja con números enteros de longitud fija, como en el caso de claves numéricas o direcciones de memoria. Además de su eficiencia, su estabilidad lo hace apropiado para aplicaciones donde es crucial mantener el orden relativo de elementos con valores iguales, como en bases de datos o sistemas de gestión de archivos.

## ¿Cómo?

### Implementación

```java
public class RadixSort {
    public static void sort(int[] array) {
        int max = getMax(array);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    private static void countingSort(int[] array, int exp) {
        int[] output = new int[array.length];
        int[] count = new int[10];

        for (int i = 0; i < array.length; i++) {
            count[(array[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[(array[i] / exp) % 10] - 1] = array[i];
            count[(array[i] / exp) % 10]--;
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = output[i];
        }
    }

    public static void main(String[] args) {
        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}

```

### Traza

**Arreglo de entrada inicial:** [170, 45, 75, 90, 802, 24, 2, 66]

#### Pasos de la Ordenación

1. **Paso 1: Ordenación por el dígito menos significativo (unidades):**
   - Conteo de apariciones de cada dígito en el arreglo y almacenamiento en un arreglo auxiliar.
    - Ajuste del arreglo auxiliar para indicar la posición final de cada dígito.
     - Colocación de los elementos en el arreglo de salida según el conteo y ajuste.
     - Arreglo ordenado: [170, 90, 802, 2, 24, 45, 75, 66]
   
2. **Paso 2: Ordenación por el siguiente dígito (decenas):**
   - Repetición del proceso anterior considerando los dígitos en la posición de las decenas.
    - Arreglo ordenado: [802, 2, 24, 45, 66, 170, 75, 90]
   
3. **Paso 3: Ordenación por el siguiente dígito (centenas):**
   - Repetición del proceso anterior considerando los dígitos en la posición de las centenas.
    - Arreglo ordenado final: [2, 24, 45, 66, 75, 90, 170, 802]
   
El arreglo está ahora completamente ordenado.
