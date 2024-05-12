public class BubbleSort {

  public static void sort(int[] array) {
    boolean sorted = false;
    int passIndex = 0;
    while (!sorted) {
      sorted = true;
      System.out.println("Starting pass " + (passIndex + 1));
      for (int j = 0; j < array.length - 1 - passIndex; j++) {
        System.out.print(
          "Comparing " + array[j] + " and " + array[j + 1] + ": "
        );
        if (array[j] > array[j + 1]) {
          int temp = array[j];
          array[j] = array[j + 1];
          array[j + 1] = temp;
          sorted = false;
          System.out.println(
            "Swapped -> " + array[j] + " with " + array[j + 1]
          );
        } else {
          System.out.println("No swap needed.");
        }
      }
      System.out.print("Array after pass " + (passIndex + 1) + ": ");
      for (int k : array) {
        System.out.print(k + " ");
      }
      System.out.println();
      passIndex++;
    }
  }

  public static void main(String[] args) {
    int[] data = { 64, 34, 25, 12, 22, 11, 90 };
    sort(data);
    System.out.println("\nSorted Array:");
    for (int i : data) {
      System.out.print(i + " ");
    }
  }
}
