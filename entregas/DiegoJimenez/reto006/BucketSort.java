public class BucketSort {
    public static void bucketSort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }

        System.out.println("Arreglo original:");
        printArray(array);

        int maxVal = array[0];
        for (int num : array) {
            maxVal = Math.max(maxVal, num);
        }
        System.out.println("\nMáximo valor encontrado: " + maxVal);

        int numBuckets = maxVal / 10 + 1;
        System.out.println("Número de buckets a utilizar: " + numBuckets);

        int[][] buckets = new int[numBuckets][array.length];
        int[] bucketIndex = new int[numBuckets];

        for (int num : array) {
            int bucketIndexToUse = num / 10;
            buckets[bucketIndexToUse][bucketIndex[bucketIndexToUse]++] = num;
        }

        System.out.println("\nBuckets generados:");
        for (int i = 0; i < numBuckets; i++) {
            System.out.print("Bucket " + i + ": ");
            printArray(buckets[i]);
        }

        for (int i = 0; i < numBuckets; i++) {
            insertionSort(buckets[i], bucketIndex[i]);
        }

        System.out.println("\nBuckets ordenados:");
        for (int i = 0; i < numBuckets; i++) {
            System.out.print("Bucket " + i + ": ");
            printArray(buckets[i]);
        }

        int index = 0;
        for (int i = 0; i < numBuckets; i++) {
            for (int j = 0; j < bucketIndex[i]; j++) {
                array[index++] = buckets[i][j];
            }
        }

        System.out.println("\nArreglo ordenado:");
        printArray(array);
    }

    static void insertionSort(int[] array, int n) {
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
    }

    static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] data = {4, 32, 53, 25, 72, 66, 15};
        bucketSort(data);
    }
}
