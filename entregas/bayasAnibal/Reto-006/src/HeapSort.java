import java.util.logging.Level;
import java.util.logging.Logger;

public class HeapSort {
    private static final Logger logger = Logger.getLogger(HeapSort.class.getName());

    public static void sort(int array[]) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(array, n, i);
            logger.log(Level.INFO, "Montículo construido: " + arrayToString(array));
        }

        for (int i = n - 1; i > 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            logger.log(Level.INFO, "Intercambio realizado: " + arrayToString(array));

            heapify(array, i, 0);
            logger.log(Level.INFO, "Montículo reducido: " + arrayToString(array));
        }
    }

    static void heapify(int array[], int n, int i) {
        int largest = i; // Inicializar largest como raíz
        int l = 2 * i + 1; // izquierda = 2*i + 1
        int r = 2 * i + 2; // derecha = 2*i + 2

        if (l < n && array[l] > array[largest])
            largest = l;

        if (r < n && array[r] > array[largest])
            largest = r;

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int array[] = {12, 11, 13, 5, 6, 7};
        logger.log(Level.INFO, "Array original: " + arrayToString(array));
        sort(array);
        logger.log(Level.INFO, "Array ordenado: " + arrayToString(array));
    }

    private static String arrayToString(int[] array) {
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
}