public class CountingSort {
    public void sort(int[]  array) {
        int length =  array.length;
        // El  arreglo de salida que tendrá los elementos ordenados
        int output[] = new int[length];
        System.out.println("Longitud del arreglo: " + length);

        // Encuentra el elemento mayor para saber el rango
        int max =  array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max)
                max =  array[i];

        }
        System.out.println("El número mayor es: " + max);

        // Arreglo de conteo
        int count[] = new int[max + 1];

        // Almacenar el conteo de cada elemento
        System.out.println("Arreglo de conteo:");
        for (int i = 0; i < length; i++) {
            count[array[i]]++;
            System.out.print("Fase " + (i + 1) + ": ");
            mostrarArray(count);
        }
        System.out.println();

        // Cambiar count[i] para que count[i] contenga la posición actual
        // de este elemento en output[]
        System.out.println("Acumular:");
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
            System.out.print("Fase " + i + ": ");
            mostrarArray(count);
        }
        System.out.println();

        // Construir el  arreglo de salida
        System.out.println("Colocar:");
        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
            System.out.print("Fase " + (length - i) + ": ");
            mostrarArray(output);
        }

        // Copiar los elementos ordenados al  arreglo original
        for (int i = 0; i < length; i++) {
             array[i] = output[i];
        }
    }
    
    public static void mostrarArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CountingSort obj = new CountingSort();
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        System.out.println("Array original:");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println();
        obj.sort(data);
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
/*
Trazabilidad del Código:

1. Inicialización y Preparación:
   - `length = 7` (longitud del arreglo)
   - Encuentra el número máximo (`max = 8`) en el arreglo.
   - Crea un arreglo `count` de tamaño `(max + 1)` para contar las ocurrencias de cada elemento.

2. Conteo de Ocurrencias:
   - Recorre el arreglo de entrada y cuenta las ocurrencias de cada elemento.
   - Muestra el progreso de conteo en cada fase.

   Arreglo de conteo:
   Fase 1: 0 0 1 0 0 0 0 0 0 
   Fase 2: 0 0 2 0 0 0 0 0 0 
   Fase 3: 0 0 2 1 0 0 0 0 0 
   Fase 4: 0 0 2 2 0 0 0 0 1 
   Fase 5: 0 0 2 2 0 0 2 0 1 
   Fase 6: 0 0 2 2 0 0 3 0 1 
   Fase 7: 0 1 2 2 0 0 3 0 1 

3. Acumulación de Conteos:
   - Ajusta `count` para que cada elemento indique la posición de inicio en el arreglo de salida.
   - Muestra el progreso de acumulación en cada fase.

   Acumular:
   Fase 1: 0 0 2 2 2 2 5 5 6 
   Fase 2: 0 0 2 4 4 4 7 7 8 
   Fase 3: 0 0 2 4 4 4 10 10 11 

4. Construcción del Arreglo de Salida:
   - Construye el arreglo `output` utilizando la información acumulada en `count`.
   - Muestra el progreso de colocación en cada fase.

   Colocar:
   Fase 1: 0 0 0 0 0 0 0 0 8 
   Fase 2: 0 0 1 0 0 0 0 0 8 
   Fase 3: 0 0 1 2 0 0 0 0 8 
   Fase 4: 0 0 1 2 3 0 0 0 8 
   Fase 5: 0 0 1 2 3 3 0 0 8 
   Fase 6: 0 0 1 2 3 3 4 0 8 
   Fase 7: 0 1 1 2 3 3 4 0 8 

5. Copia de Elementos Ordenados al Arreglo Original:
   - Copia los elementos ordenados de `output` de vuelta al arreglo original.

    Resultado Final:
Después de que el algoritmo Counting Sort complete todas las fases de colocación, el arreglo original queda completamente ordenado.

Array ordenado:
1 2 2 3 3 4 8 
 */