public class InsertionSort {
  public static void sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int current = array[i];
      int j = i - 1;
      while (j >= 0 && array[j] > current) {
        array[j + 1] = array[j]; // Desplaza el elemento hacia la derecha
        j--;
      }
      array[j + 1] = current; // Inserta el elemento en su lugar correcto

      // Imprime el estado actual del array
      System.out.print("Iteración " + i + ": ");
      for (int value : array) {
        System.out.print(value + " ");
      }
      System.out.println();
    }
  }

  public static void main(String[] args) {
    int[] data = { 22, 11, 99, 88, 9, 7, 42 };
    System.out.println("Array original:");
    for (int i : data) {
      System.out.print(i + " ");
    }
    System.out.println();
    System.out.println("=".repeat(35));
    sort(data);
    System.out.println("=".repeat(35));
    System.out.println("Array ordenado:");
    for (int value : data) {
      System.out.print(value + " ");
    }
  }
}