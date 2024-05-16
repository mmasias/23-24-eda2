package entregas.gomezSantiago.Reto006.AlgoritmosOrdenacion;

public class BubbleSort {
    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) { // i es el número de pasadas completas
            System.out.println("+----------------------+");
            System.out.println("| Pasada " + (i + 1) + ":"); // Indica la pasada actual del algoritmo
            System.out.println("+----------------------+");
            for (int j = 0; j < n - 1; j++) { // j es
                System.out.println("+--------------------------------------------------+");
                System.out.println("| Comparando elementos en índices " + j + " y " + (j + 1) + ": " + array[j] + " y " + array[j + 1]);
                System.out.println("+--------------------------------------------------+");
                if (array[j] > array[j + 1]) {
                    System.out.println("+----------------------------------------------------+");
                    System.out.println("| Los elementos están desordenados. Se intercambiarán."); // Indica que se intercambiarán los elementos
                    System.out.println("+----------------------------------------------------+");
                    // Intercambio de elementos
                        int temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    System.out.println("+--------------------------+");
                    System.out.println("| Elementos intercambiados."); // Confirma el intercambio de elementos
                    System.out.println("+--------------------------+");
                } else {
                    System.out.println("+---------------------------------+");
                    System.out.println("| Los elementos ya están ordenados."); // Indica que los elementos ya están en orden
                    System.out.println("+---------------------------------+");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("+-----------------+");
        System.out.println("| Array original:");
        System.out.println("+-----------------+");
        for (int i : data) {
            System.out.print(i + " ");
        }
        System.out.println("\n\nPasos del algoritmo Bubble Sort:");

        sort(data);
        System.out.println("+-----------------+");
        System.out.println("| Array ordenado:");
        System.out.println("+-----------------+");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
