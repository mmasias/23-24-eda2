## Algoritmo de Ordenamiento por Selección

El algoritmo de ordenamiento por selección es un método sencillo e intuitivo para ordenar una lista/array. Funciona seleccionando repetidamente el elemento más pequeño (o más grande) de la lista no ordenada y moviéndolo al principio (o final) de la lista ordenada.

### Descripción del Algoritmo

1. **Inicio**: El algoritmo comienza seleccionando el primer elemento de la lista y considerándolo como el elemento más pequeño.

2. **Búsqueda del elemento más pequeño**: Luego, busca el elemento más pequeño en el resto de la lista no ordenada, comparándolo con el elemento seleccionado actualmente. Si encuentra un elemento más pequeño, lo marca como el nuevo elemento más pequeño.

3. **Intercambio**: Después de terminar de buscar en la lista no ordenada, intercambia el elemento más pequeño encontrado con el primer elemento de la lista no ordenada.

4. **Avance del índice de inicio**: Incrementa el índice de inicio para excluir el elemento recién ordenado, ya que la parte ordenada de la lista ahora incluye un elemento adicional.

5. **Repetición**: Repite los pasos anteriores para el resto de la lista no ordenada, cada vez seleccionando el siguiente elemento no ordenado como el "inicio" y encontrando el elemento más pequeño en la lista no ordenada restante.

6. **Finalización**: Cuando el algoritmo ha recorrido toda la lista, la lista estará completamente ordenada.

### Complejidad Temporal

El algoritmo de selección tiene una complejidad de tiempo de O(n^2), lo que significa que su rendimiento puede deteriorarse rápidamente con el aumento del tamaño de la lista. Es adecuado para listas pequeñas o medianas, pero puede ser ineficiente para listas grandes.

## Código Fuente

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
´´´
## Trazabilidad Del Código

Lista original: ([29, 20, 73, 34, 64])

**Paso 1:**
- Encuentra el elemento más pequeño en la lista: 20
- Intercambia el elemento más pequeño con el primer elemento: [20, 29, 73, 34, 64]

**Paso 2:**
- Encuentra el elemento más pequeño en la lista desde la posición 1: 29
- No se realiza intercambio ya que el elemento más pequeño ya está en su lugar: [20, 29, 73, 34, 64]

**Paso 3:**
- Encuentra el elemento más pequeño en la lista desde la posición 2: 34
- Intercambia el elemento más pequeño con el elemento en la posición 2: [20, 29, 34, 73, 64]

**Paso 4:**
- Encuentra el elemento más pequeño en la lista desde la posición 3: 64
- No se realiza intercambio ya que el elemento más pequeño ya está en su lugar: [20, 29, 34, 64, 73]

**Paso 5:**
- No hay más elementos para seleccionar, la lista está ordenada.

Lista Final Ordenada: ([20, 29, 34, 64, 73])
