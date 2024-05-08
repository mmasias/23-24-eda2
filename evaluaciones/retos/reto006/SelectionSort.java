package evaluaciones.retos.reto006;

public class SelectionSort {
    public static void sort(int[] array) {
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            System.out.println("Las operaciones dentro del while se repetirán " + array.length + " veces");
            int minIndex = startIndex;
            for (int j = startIndex + 1; j < array.length; j++) {
                System.out.println("Buscando el elemento menor del array....");
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Encuentra el índice del elemento más pequeño
                    System.out.println("El elemento más pequeño del array es: " + array[minIndex] + "y su índice es " + minIndex);
                }
            }
            // Intercambio del elemento mínimo encontrado con el elemento en startIndex
            System.out.println("Se intercambia " + array[startIndex] + " por " + array[minIndex]);
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;
            startIndex++;
            System.out.println("Se han hecho " + startIndex + " pasadas");
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
