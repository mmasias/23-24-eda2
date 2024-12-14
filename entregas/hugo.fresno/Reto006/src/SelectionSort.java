public class SelectionSort {
    public static void sort(int[] array) {
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            int minIndex = startIndex;
            System.out.println("Evaluando subarreglo desde el índice " + startIndex);
            for (int j = startIndex + 1; j < array.length; j++) {
                System.out.print("Comparando " + array[j] + " con " + array[minIndex]);
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Encuentra el índice del elemento más pequeño
                    System.out.println(" => nuevo mínimo encontrado: " + array[minIndex]);
                } else {
                    System.out.println(" => no es menor que el mínimo actual");
                }
            }
            // Intercambio del elemento mínimo encontrado con el elemento en startIndex
            System.out.println("Intercambiando " + array[startIndex] + " con " + array[minIndex]);
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;

            System.out.print("Arreglo después del intercambio: ");
            for (int k = 0; k < array.length; k++) {
                System.out.print(array[k] + " ");
            }
            System.out.println("\n");
            startIndex++;
        }
    }

    public static void main(String[] args) {
        int[] data = {29, 20, 73, 34, 64};
        System.out.println("Arreglo original:");
        for (int value : data) {
            System.out.print(value + " ");
        }
        System.out.println("\nIniciando el proceso de ordenamiento...");
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
