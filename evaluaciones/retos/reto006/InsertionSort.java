package evaluaciones.retos.reto006;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.println("Iteración número " + i);
            int current = array[i];
            System.out.println("Número a comparar: " + current);
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                System.out.println("El número " + current + " se puede desplazar");
                array[j + 1] = array[j];  // Desplaza el elemento hacia la derecha
                j--;
                System.out.println("Array después del desplazamiento:" + array.toString());
            }
            System.out.println(current + " se inserta en el lugar correcto");
            array[j + 1] = current; // Inserta el elemento en su lugar correcto
        }
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        sort(data);
        System.out.println("Array ordenado:");
        for (int value : data) {
            System.out.print(value + " ");
        }
    }
}
