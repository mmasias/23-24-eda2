package evaluaciones.retos.reto006;

public class CountingSort {
    public void sort(int[]  array) {
        int length =  array.length;
        System.out.println("El array tiene una longitud de " + length);
        // El  arreglo de salida que tendrá los elementos ordenados
        int output[] = new int[length];

        System.out.println("Buscando el elemento mayor para saber el rango...");
        int max =  array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max) {
                max =  array[i];
                System.out.println("El elemento mayor es " + max);
            }
        }

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
