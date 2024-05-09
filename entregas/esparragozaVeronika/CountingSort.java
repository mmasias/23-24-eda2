package entregas.esparragozaVeronika;

public class CountingSort {
    public void sort(int[]  array) {
        System.out.println("Array original:");
        for (int num : array) {
            System.out.print(num + " ");
        }

        int length =  array.length;
        // El  arreglo de salida que tendrá los elementos ordenados
        int output[] = new int[length];

        // Encuentra el elemento mayor para saber el rango
        int max =  array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max)
                max = array[i];
            }

        // Arreglo de conteo
        int count[] = new int[max + 1];
        //System.out.println("Arreglo de conteo:" + count.length);

        // Almacenar el conteo de cada elemento
        System.out.println("Arreglo de conteo:");
        for (int i = 0; i < length; i++) {
            count[array[i]]++;
            System.out.println("\u001B[32m" + "Valor: " + array[i] + "\u001B[0m " + "se repite [" + count[array[i]] + "] veces");
        }

        System.out.println(" ");

        // Cambiar count[i] para que count[i] contenga la posición actual
        // de este elemento en output[]
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Construir el  arreglo de salida
        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        System.out.println("Array en proceso:");
        for (int i = 0; i < length; i++) {
            array[i] = output[i];
            for (int value : array) {
                if (value == output[i] || value == array[i]) {
                    System.out.print("\u001B[35m" + value + " ");
                } else {
                    System.out.print("\033[38;5;220m" + value + " ");
                }
                System.out.print("\u001B[0m ");
            }
            System.out.println(" ");
        }
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
