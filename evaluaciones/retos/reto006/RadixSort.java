package evaluaciones.retos.reto006;

public class RadixSort {
    int getMax(int[] array) {
        System.out.println("Buscando el elemento mayor para saber el rango...");
        int max =  array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max =  array[i];
                System.out.println("El elemento mayor es " + max);
            }
        }
        return max;

    }
    // Método que implementa Counting Sort
    void countingSort(int[] array) {
        int length =  array.length;
        System.out.println("El array tiene una longitud de " + length);
        // El  arreglo de salida que tendrá los elementos ordenados
        int output[] = new int[length];
        // El rango del arreglo
        int max = getMax(array);

        // Arreglo de conteo
        int count[] = new int[max + 1];

        System.out.println("Almacenando el conteo de cada elemento...");
        for (int i = 0; i < length; i++) {
            System.out.println("+1 a " + array[i]);
            count[array[i]]++;
        }

        // Cambiar count[i] para que count[i] contenga la posición actual
        // de este elemento en output[]
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        System.out.println("Construyendo el arreglo de salida...");
        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        System.out.println("Copiando los elementos ordenados al arreglo original...");
        for (int i = 0; i < length; i++) {
             array[i] = output[i];
        }
    }

    void sort(int[] array) {
        int max = getMax(array);

        System.out.println("Aplicando Counting Sort para ordenar los elementos según el valor posicional...");
        for (int i = 1; max / i > 0; i *= 10) {
            countingSort(array);
        }
    }

    public static void main (String[] args) {
        RadixSort radixSort = new RadixSort();
        int[] data = {125, 4, 985, 32, 66, 1, 187};
        System.out.println("Array original:");
        for (int i : data) {
            System.out.print(i + " ");
        }
        radixSort.sort(data);
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
