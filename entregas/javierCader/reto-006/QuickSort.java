import java.util.Arrays;

public class QuickSort {

  public static void sort(int[] array, int low, int high) {
    if (low < high) {
      System.out.println(
        "Sort called: [" +
        low +
        ", " +
        high +
        "] -> " +
        Arrays.toString(Arrays.copyOfRange(array, low, high + 1))
      );
      int pivotIndex = partition(array, low, high);
      System.out.println(
        "Pivot at index " + pivotIndex + " -> " + array[pivotIndex]
      );
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
      }
    }
    int temp = array[i + 1];
    array[i + 1] = array[high];
    array[high] = temp;

    System.out.println(
      "Partition: [" +
      low +
      ", " +
      high +
      "] with pivot " +
      pivot +
      " -> " +
      Arrays.toString(Arrays.copyOfRange(array, low, high + 1))
    );
    return i + 1;
  }

  public static void main(String[] args) {
    int[] data = { 10, 7, 8, 9, 1, 5 };
    System.out.println("Original Array:");
    System.out.println(Arrays.toString(data));
    sort(data, 0, data.length - 1);
    System.out.println("Sorted Array:");
    System.out.println(Arrays.toString(data));
  }
}
