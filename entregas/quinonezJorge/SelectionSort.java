import java.util.Scanner;

public class SelectionSort {
  public static void sort(int[] array) {
    int startIndex = 0;
    while (startIndex < array.length - 1) {
      int minIndex = startIndex;
      System.out.println("El elemento mas pequeno es array[" + minIndex + "]: " + array[minIndex]);
      for (int j = startIndex + 1; j < array.length; j++) {
        if (array[j] < array[minIndex]) {
          System.out.println(array[j] + " es menor que " + array[minIndex]);
          minIndex = j; // Encuentra el índice del elemento más pequeño
        }
      }
      System.out.println("Se intercambia " + array[minIndex] + " con " + array[startIndex]);
      // Intercambio del elemento mínimo encontrado con el elemento en startIndex
      int temp = array[minIndex];
      array[minIndex] = array[startIndex];
      array[startIndex] = temp;
      startIndex++;

      System.out.print("Array resultante: [");
      for (int k = 0; k < array.length; k++) {
        System.out.print(array[k] + " ");
      }
      System.out.println("]");
      new Scanner(System.in).nextLine();
    }
  }

  public static void main(String[] args) {
    int[] data = { 29, 20, 73, 34, 64 };
    sort(data);
    System.out.println("Array ordenado:");
    for (int i : data) {
      System.out.print(i + " ");
    }
  }
}