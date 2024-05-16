package entregas.gomezSantiago.Reto006.AlgoritmosOrdenacion;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i]; // Almacena el valor del elemento actual que se está evaluando
            int j = i - 1; // Inicializa j como el índice del elemento anterior al elemento actual
            while (j >= 0 && array[j] > current) {
                System.out.println("+---------------------------------------------------------+");
                System.out.println("| Desplazando elemento en índice " + j + " hacia la derecha"); // Indica que se está desplazando un elemento hacia la derecha
                System.out.println("+---------------------------------------------------------+");
                array[j + 1] = array[j];  // Desplaza el elemento hacia la derecha
                j--; // Reduce el valor de j para evaluar el siguiente elemento hacia la izquierda
            }
            array[j + 1] = current; // Inserta el elemento en su lugar correcto
            System.out.println("+----------------------------------------------------------+");
            System.out.println("| Insertando elemento " + current + " en índice " + (j + 1)); // Indica el lugar donde se inserta el elemento actual
            System.out.println("+----------------------------------------------------------+");
        }
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        System.out.println("+---------------------+");
        System.out.println("| Array original:");
        System.out.println("+---------------------+");
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println("\n\nPasos del algoritmo Insertion Sort:");

        sort(data);
        System.out.println("+---------------------+");
        System.out.println("| Array ordenado:");
        System.out.println("+---------------------+");
        for (int value : data) {
            System.out.print(value + " ");
        }
    }
}
