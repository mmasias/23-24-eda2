package entregas.oteroJorge.reto006;

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

        // Almacenar el conteo de cada elemento
        for (int i = 0; i < length; i++) {
            count[array[i]]++;
        }

        // Mostrar el conteo de cada elemento
        System.out.println("Conteo de cada elemento:");
        for (int i = 0; i <= max; i++) {
            if (count[i] > 0) {
                System.out.println("Elemento " + i + ": " + count[i]);
            }
        }

        // Cambiar count[i] para que count[i] contenga la posición actual
        // de este elemento en output[]
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Construir el arreglo de salida
        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        // Mostrar el arreglo de salida construido
        System.out.println("Arreglo de salida construido:");
        for (int i = 0; i < length; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();

        // Copiar los elementos ordenados al arreglo original
        for (int i = 0; i < length; i++) {
            array[i] = output[i];
        }
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
        System.out.println();
    }
}

