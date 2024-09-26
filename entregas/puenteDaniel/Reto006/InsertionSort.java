package entregas.puenteDaniel.Reto006;

public class InsertionSort {
    public static void sort(int[] array) {
        System.out.println("Lista original: " + arrayToString(array));

        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i - 1;

            System.out.println("Iteración " + i + ": Insertar " + current + " en su posición correcta");
            while (j >= 0 && array[j] > current) {
                System.out.println("Comparamos " + current + " con " + array[j] + ".");
                System.out.println(array[j] + " es mayor que " + current + ", movemos " + array[j] + " a la derecha.");
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current;
            System.out.println("Insertamos " + current + " en la posición " + (j + 1) + ".");
            System.out.println("Lista resultante: " + arrayToString(array));
        }

        System.out.println("Lista Final Ordenada:");
        System.out.println("(" + arrayToString(array) + ")");
    }

    // Método para convertir un arreglo en una cadena de texto
    static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        sort(data);
    }
}
