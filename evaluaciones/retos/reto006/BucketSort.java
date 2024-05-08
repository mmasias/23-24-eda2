package evaluaciones.retos.reto006;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort {
    public void sort(int[] array) {
        int length = array.length;
        if (length <= 0) {
            return;
        }

        ArrayList<Integer>[] bucket = new ArrayList[length];

        System.out.println("Creando 'buckets' vacíos...");
        for (int i = 0; i < length; i++) {
            bucket[i] = new ArrayList<Integer>();
        }

        System.out.println("Añadiendo elementos a los 'buckets'...");
        for (int i = 0; i < length; i++) {
            int bucketIndex = array[i] * length;
            bucket[bucketIndex].add(array[i]);
        }

        System.out.println("Ordenando los elementos de cada 'bucket'...");
        for (int i = 0; i < length; i++) {
            Collections.sort((bucket[i]));
        }

        System.out.println("Obteniendo el array ordenado...");
        int index = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < bucket[i].size(); j++ ) {
                array[index++] = bucket[i].get(j);
            }
        }
    }
    public static void main(String[] args) {
        BucketSort bucketSort = new BucketSort();
        int[] data = {98, 1, 63, 25, 128, 77};
        System.out.println("Array original: ");
        for (int i : data) {
            System.out.print(i + " ");
        }
        bucketSort.sort(data);
        System.out.println("Array ordenado: ");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
