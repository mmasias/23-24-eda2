public class QuickSort {

    public static void sort(int[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);

            System.out.println("Pivote elegido en la posición " + pivotIndex + " con valor " + array[pivotIndex]);
            System.out.print("Estado del arreglo después de particionar: ");
            printArray(array);

            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);
        }
    }

    private static int partition(int[] array, int low, int high) {
        int pivot = array[high]; 
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            if (array[j] < pivot) {
                i++;

                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                System.out.println(
                        "Intercambiando " + array[i] + " con " + array[j] + " por ser menor que el pivote " + pivot);
            }
        }

        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        System.out.println("Intercambiando pivote " + array[i + 1] + " con " + pivot);

        return i + 1; 
    }

    private static void printArray(int[] array) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = { 10, 7, 8, 9, 1, 5 };
        System.out.println("Array original:");
        printArray(data);
        sort(data, 0, data.length - 1);
        System.out.println("Array ordenado:");
        printArray(data);
    }
}
