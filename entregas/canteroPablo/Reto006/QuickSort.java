public class QuickSort {
    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            System.out.println("Ordenando desde índice " + low + " hasta " + high);
            int pivotIndex = partition(array, low, high);

            System.out.println("Pivote en posición " + pivotIndex + ", valor: " + array[pivotIndex]);
            printArray(array);

            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        System.out.println("Pivote seleccionado: " + pivot + " en índice " + high+" ,posicion " + (high + 1));
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            System.out.println("Comparando " + array[j] + " con pivote " + pivot);
            if (array[j] < pivot) {
                i++;
                System.out.println("Intercambiando " + array[i] + " con " + array[j]);
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                printArray(array);
            }
        }

        System.out.println("Colocando pivote en posición final");
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        printArray(array);

        return i + 1;
    }

    private static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {10, 7, 8, 9, 1, 5};
        System.out.println("Array original:");
        printArray(data);
        sort(data, 0, data.length - 1);
        System.out.println("Array ordenado:");
        printArray(data);
    }
}

