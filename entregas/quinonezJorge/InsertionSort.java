import java.util.Scanner;

public class InsertionSort {
  public static void sort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int current = array[i];
      int j = i - 1;

      System.out.println("Elemento a comparar: " + current);
      System.out.println("Elemento anterior: " + array[j]);
      new Scanner(System.in).nextLine();

      while (j >= 0 && array[j] > current) {
        System.out.println(array[j] + " es mayor que " + current + ": Se desplaza a la derecha");
        array[j + 1] = array[j]; // Desplaza el elemento hacia la derecha
        j--;
      }

      array[j + 1] = current; // Inserta el elemento en su lugar correcto

      System.out.print("El array ahora es: [ ");
      for (int k = 0; k < array.length; k++) {
        System.out.print(array[k] + " ");
      }
      System.out.println("]");
      new Scanner(System.in).nextLine();
    }
  }

  public static void main(String[] args) {
    int[] data = { 22, 11, 99, 88, 9, 7, 42 };
    System.out.print("Array inicial: [ ");
    for (int i : data) {
      System.out.print(i + " ");
    }
    System.out.println("]");
    sort(data);
    System.out.println("Array ordenado:");
    for (int value : data) {
      System.out.print(value + " ");
    }
  }
}