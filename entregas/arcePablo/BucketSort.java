import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public static void bucketSort(float[] array) {
        int n = array.length;
        if (n <= 0) return;

        @SuppressWarnings("unchecked")
        ArrayList<Float>[] buckets = new ArrayList[n];

        // Inicializar cada bucket
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; i++) {
            int bucketIndex = (int) (n * array[i]);
            buckets[bucketIndex].add(array[i]);
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < buckets[i].size(); j++) {
                array[index++] = buckets[i].get(j);
            }
        }
    }

    public static void main(String[] args) {
        float[] array = {0.42f, 0.32f, 0.33f, 0.52f, 0.37f, 0.47f, 0.51f};
        System.out.println("Array original:");
        printArray(array);

        bucketSort(array);

        System.out.println("Array ordenado:");
        printArray(array);
    }

    private static void printArray(float[] array) {
        for (float value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
