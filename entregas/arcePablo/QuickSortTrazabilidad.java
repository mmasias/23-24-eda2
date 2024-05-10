public class QuickSortTrazabilidad {
    // Método para realizar el ordenamiento
    public static void sort(int[] array, int low, int high) throws InterruptedException {
        if (low < high) {
            // Particiona el arreglo y obtiene el índice del pivote en su posición correcta
            int pivotIndex = partition(array, low, high);

            // Ordena recursivamente los elementos antes y después de la partición
            sort(array, low, pivotIndex - 1);
            sort(array, pivotIndex + 1, high);

            System.out.println("Estado del array después de la partición en el índice " + pivotIndex + ": " + arrayAsString(array));
            Thread.sleep(500);
        }
    }

    // Método para particionar el arreglo
    private static int partition(int[] array, int low, int high) {
        int pivot = array[high];  // Elige el último elemento como pivote
        int i = (low - 1);  // Índice de menor elemento

        for (int j = low; j < high; j++) {
            // Si el elemento actual es menor que el pivote
            if (array[j] < pivot) {
                i++;

                // Intercambia arr[i] y arr[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        // Intercambia el elemento pivote con el elemento en la posición i+1
        int temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;  // Devuelve el índice del pivote
    }

    // Método auxiliar para imprimir el array como una cadena.
    private static String arrayAsString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException {
        int[] data = {10, 7, 8, 9, 1, 5};
        System.out.println("Array original:");
        System.out.println(arrayAsString(data));
        
        sort(data, 0, data.length - 1);
        
        System.out.println("Array ordenado:");
        System.out.println(arrayAsString(data));
    }
}
