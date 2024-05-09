public class CountingSort {
    public void sort(int[] array) {
        int length = array.length;
        // El arreglo de salida que tendrá los elementos ordenados
        int output[] = new int[length];

        // Encuentra el elemento mayor para saber el rango
        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        // Arreglo de conteo
        int count[] = new int[max + 1];

        
        System.out.println("Estado inicial del arreglo:");
        printArray(array);

        // Almacenar el conteo de cada elemento
        for (int i = 0; i < length; i++) {
            count[array[i]]++;
        }

       
        System.out.println("\nConteo de cada elemento:");
        printArray(count);

        // Cambiar count[i] para que count[i] contenga la posición actual
        // de este elemento en output[]
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

     
        System.out.println("\nConteo actualizado:");
        printArray(count);

        // Construir el arreglo de salida
        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;

            
            System.out.println("\nDespués de colocar " + array[i] + " en posición " + (count[array[i]] + 1) + ":");
            printArray(output);
        }

        // Copiar los elementos ordenados al arreglo original
        for (int i = 0; i < length; i++) {
            array[i] = output[i];
        }
    }

    // Método auxiliar para imprimir un arreglo
    static void printArray(int array[]) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {
        CountingSort obj = new CountingSort();
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        obj.sort(data);
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}