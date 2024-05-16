package entregas.gomezSantiago.Reto006.AlgoritmosOrdenacion;

public class CountingSort {
    public void sort(int[] array) {
        int length = array.length;
        // Arreglo de salida que tendrá los elementos ordenados
        int output[] = new int[length];

        // Encuentra el elemento mayor para saber el rango
        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max)
                max = array[i];
        }

        // Arreglo de conteo
        int count[] = new int[max + 1];

        // Almacena el conteo de cada elemento
        for (int i = 0; i < length; i++) {
            count[array[i]]++;
        }

        // Cambia count[i] para que count[i] contenga la posición actual
        // de este elemento en output[]
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Construye el arreglo de salida
        for (int i = length - 1; i >= 0; i--) {
            // Intercambio de elementos
            System.out.println("+-----------------------------------------------------------------------------------------------------+");
            System.out.println("| Colocando elemento " + array[i] + " en la posición " + (count[array[i]] - 1) + " del arreglo de salida");
            System.out.println("+-----------------------------------------------------------------------------------------------------+");
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Copia los elementos ordenados al arreglo original
        for (int i = 0; i < length; i++) {
             array[i] = output[i];
        }
    }

    public static void main(String[] args) {
        CountingSort obj = new CountingSort();
        int[] data = {4, 2, 2, 8, 3, 3, 1};

        // Impresión del arreglo original
        System.out.println("+-----------------+");
        System.out.println("| Array original:");
        System.out.println("+-----------------+");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println("\n\nPasos del algoritmo Counting Sort:");


        // Ordena el arreglo
        obj.sort(data);

        // Impresión del arreglo ordenado
        System.out.println("+-----------------+");
        System.out.println("| Array ordenado:");
        System.out.println("+-----------------+");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
