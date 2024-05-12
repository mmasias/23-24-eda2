public class SelectionSort {

  public static void sort(int[] array) {
    int startIndex = 0;
    while (startIndex < array.length - 1) {
      int minIndex = startIndex;
      System.out.println("Starting new iteration from index " + startIndex);

      for (int j = startIndex + 1; j < array.length; j++) {
        System.out.print(
          "Comparing " +
          array[j] +
          " (index " +
          j +
          ") with " +
          array[minIndex] +
          " (current min index " +
          minIndex +
          "): "
        );
        if (array[j] < array[minIndex]) {
          minIndex = j;
          System.out.println("New minimum found at index " + minIndex);
        } else {
          System.out.println("No change.");
        }
      }

      System.out.println(
        "Swapping " + array[startIndex] + " and " + array[minIndex]
      );
      int temp = array[minIndex];
      array[minIndex] = array[startIndex];
      array[startIndex] = temp;

      System.out.print("Array state after swap: ");
      for (int i : array) {
        System.out.print(i + " ");
      }
      System.out.println();

      startIndex++;
    }
  }

  public static void main(String[] args) {
    int[] data = { 29, 20, 73, 34, 64 };
    sort(data);
    System.out.println("\nSorted Array:");
    for (int i : data) {
      System.out.print(i + " ");
    }
  }
}
