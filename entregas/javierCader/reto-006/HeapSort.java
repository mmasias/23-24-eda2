import java.util.Arrays;

public class HeapSort {

  public static void sort(int[] array) {
    int n = array.length;

    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(array, n, i);
      System.out.println("Build heap: " + Arrays.toString(array));
    }

    for (int i = n - 1; i > 0; i--) {
      int temp = array[0];
      array[0] = array[i];
      array[i] = temp;

      System.out.println(
        "Swap root with index " + i + ": " + Arrays.toString(array)
      );

      heapify(array, i, 0);
    }
  }

  static void heapify(int[] array, int n, int i) {
    int largest = i;
    int l = 2 * i + 1;
    int r = 2 * i + 2;

    if (l < n && array[l] > array[largest]) largest = l;

    if (r < n && array[r] > array[largest]) largest = r;

    if (largest != i) {
      int swap = array[i];
      array[i] = array[largest];
      array[largest] = swap;

      System.out.println(
        "Heapify at index " + i + ": " + Arrays.toString(array)
      );

      heapify(array, n, largest);
    }
  }

  public static void main(String[] args) {
    int[] array = { 12, 11, 13, 5, 6, 7 };
    System.out.println("Original Array:");
    System.out.println(Arrays.toString(array));

    sort(array);

    System.out.println("Sorted Array:");
    System.out.println(Arrays.toString(array));
  }
}
