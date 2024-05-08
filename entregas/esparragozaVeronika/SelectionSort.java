package entregas.esparragozaVeronika;

public class SelectionSort {
    static int temp;
    public static void sort(int[] array) {
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            System.out.println("\u001B[37m" + "Iteración: " + startIndex + "\u001B[0m");
            int minIndex = startIndex;
            for (int j = startIndex + 1; j < array.length; j++) {
                System.out.println("--> Comparando " + array[j] + " con el valor minimo actual: " + array[minIndex]);

                System.out.println("Array en proceso:");
                for (int i = 0; i < array.length; i++) {
                    if (temp != 0 && array[i] == array[minIndex] || array[i] == array[startIndex]) {
                        System.out.print("\u001B[35m" + array[i] + " ");
                    } else {
                        System.out.print("\033[38;5;220m" + array[i] + " ");
                    }
                }
                System.out.println("\u001B[0m");
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Encuentra el índice del elemento más pequeño
                }
            }

            temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;

            startIndex++;
        }
    }

    public static void main(String[] args) {
        int[] data = {110, 29, 68, 20, 73, 34, 1, 64};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}