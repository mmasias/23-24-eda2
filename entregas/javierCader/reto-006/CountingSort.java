import java.util.Arrays;

public class CountingSort {

  public void sort(int[] array) {
    int length = array.length;
    int output[] = new int[length];

    int max = array[0];
    for (int i = 1; i < length; i++) {
      if (array[i] > max) max = array[i];
    }
    System.out.println("Maximum value found: " + max);

    int count[] = new int[max + 1];
    for (int i = 0; i < length; i++) {
      count[array[i]]++;
    }
    System.out.println(
      "Count array after counting elements: " + Arrays.toString(count)
    );

    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }
    System.out.println(
      "Count array after accumulation: " + Arrays.toString(count)
    );

    for (int i = length - 1; i >= 0; i--) {
      output[count[array[i]] - 1] = array[i];
      count[array[i]]--;
    }
    System.out.println(
      "Output array after sorting: " + Arrays.toString(output)
    );

    for (int i = 0; i < length; i++) {
      array[i] = output[i];
    }
    System.out.println(
      "Final sorted array copied to original array: " + Arrays.toString(array)
    );
  }

  public static void main(String[] args) {
    CountingSort obj = new CountingSort();
    int[] data = { 4, 2, 2, 8, 3, 3, 1 };
    System.out.println("Original Array: " + Arrays.toString(data));
    obj.sort(data);
    System.out.println("Sorted Array:");
    for (int num : data) {
      System.out.print(num + " ");
    }
  }
}
