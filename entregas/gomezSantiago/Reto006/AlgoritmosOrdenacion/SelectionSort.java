package entregas.gomezSantiago.Reto006.AlgoritmosOrdenacion;

public class SelectionSort {
    public static void sort(int[] array) {
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            System.out.println("+-------------------------+");
            System.out.println("| Iteración " + (startIndex + 1) + ":");
            System.out.println("+-------------------------+");
            int minIndex = startIndex;
            for (int j = startIndex + 1; j < array.length; j++) {
                System.out.println("+-------------------------------------------------+");
                System.out.println("| Comparando elementos en índices " + j + " y " + minIndex + ": " + array[j] + " y " + array[minIndex]);
                System.out.println("+-------------------------------------------------+");
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Encuentra el índice del elemento más pequeño
                }
            }
            System.out.println("+-----------------------------------------------------------------------+");
            System.out.println("| Intercambio del elemento mínimo encontrado con el elemento en el índice " + startIndex);
            System.out.println("+-----------------------------------------------------------------------+");
            // Intercambio del elemento mínimo encontrado con el elemento en startIndex
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;
            startIndex++;
        }
    }

    public static void main(String[] args) {
        int[] data = {29, 20, 73, 34, 64};
        System.out.println("+---------------------+");
        System.out.println("| Array original:");
        System.out.println("+---------------------+");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println("\n\nPasos del algoritmo Selection Sort:");

        sort(data);
        System.out.println("+---------------------+");
        System.out.println("| Array ordenado:");
        System.out.println("+---------------------+");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
