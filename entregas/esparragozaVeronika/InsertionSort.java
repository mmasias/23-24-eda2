package entregas.esparragozaVeronika;

public class InsertionSort {
static int current;
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.println("\u001B[37m" + "Iteración: " + i + "\u001B[0m");
            current = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > current) {
                for (int value : array) {
                    System.out.print("\u001B[35m" + value + "\u001B[0m ");
                }
                array[j + 1] = array[j];  // Desplaza el elemento hacia la derecha
                System.out.println(" ");
                j--;

                for (int value : array) {
                    if (value == array[j + 1]) {
                        System.out.print("\033[38;5;220m" + value);
                    } else {
                        System.out.print("\u001B[35m" + value);
                    }
                    System.out.print("\u001B[0m ");
                }
                System.out.println(" ");

            }
            System.out.println("Colocando el valor: " + current + " en su lugar");
            array[j + 1] = current; // Inserta el elemento en su lugar correcto

            System.out.println("\u001B[32m" + "Array en proceso:");
            for (int value : array) {
                System.out.print(value + " ");
            }
            System.out.println("\u001B[0m ");
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