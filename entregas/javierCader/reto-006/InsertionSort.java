public class InsertionSort {

  public static void sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int current = array[i];
      int j = i - 1;

      System.out.println("Considering element " + current + " at index " + i);

      while (j >= 0 && array[j] > current) {
        System.out.println(
          "Since " +
          array[j] +
          " > " +
          current +
          ", moving " +
          array[j] +
          " from index " +
          j +
          " to index " +
          (j + 1)
        );
        array[j + 1] = array[j];
        j--;
      }

      array[j + 1] = current;
      System.out.println("Placing " + current + " at index " + (j + 1));

      System.out.print("Array after placing " + current + ": ");
      for (int value : array) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[] data = { 22, 11, 99, 88, 9, 7, 42 };
    sort(data);
    System.out.println("\nSorted Array:");
    for (int value : data) {
      System.out.print(value + " ");
    }
  }
}
