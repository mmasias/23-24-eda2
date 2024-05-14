# Selection sort (Ordenamiento por selección)

## ¿Por qué?

Aunque no es el más eficiente en todos los casos, especialmente con listas grandes, es útil en situaciones donde la memoria es limitada o cuando el costo de intercambiar elementos es significativamente más alto que el costo de comparar elementos. 

## ¿Qué?

El Selection Sort es un algoritmo de ordenamiento que divide la lista en dos partes: una sublista de elementos ya ordenados, que se construye de izquierda a derecha al principio de la lista, y una sublista de elementos restantes por ordenar que ocupan el resto de la lista. Funciona seleccionando repetidamente el elemento más pequeño (o mayor, dependiendo del orden deseado) de la sublista de elementos sin ordenar, y moviéndolo al final de la sublista ordenada.

## ¿Para qué?

El ordenamiento por selección se utiliza para ordenar datos de manera sencilla y predecible. Aunque su complejidad de tiempo en el peor caso es O(n²), similar a Bubble Sort, en realidad realiza menos intercambios (movimientos), lo que lo hace preferible en escenarios donde el costo de intercambiar es alto. Es especialmente útil en entornos de aprendizaje y en aplicaciones donde la cantidad de datos es pequeña y la simplicidad del algoritmo es una ventaja sobre la eficiencia de ejecución.

## ¿Cómo?

### Implementación

```java
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
```

### Traza

**Arreglo de entrada inicial:** [29, 20, 73, 34, 64]

#### Pasos de la Ordenación

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
   
El arreglo está ahora completamente ordenado.
