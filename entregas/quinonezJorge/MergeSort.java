import java.util.Scanner;

public class MergeSort {

  // Método para dividir y fusionar el array
  public static void sort(int[] array, int left, int right) {
    System.out.println();
    if (left < right) {
      // Encuentra el punto medio del vector.
      int middle = (left + right) / 2;

      // Divide la primera y segunda mitad (llamada recursiva).
      System.out.print("Se dividira la primera mitad del array: [ ");
      for (int i = left; i <= middle; i++) {
        System.out.print(array[i] + " ");
      }
      System.out.println("]");
      new Scanner(System.in).nextLine();
      sort(array, left, middle);

      System.out.print("Se dividira la segunda mitad del array: [ ");
      for (int i = middle + 1; i <= right; i++) {
        System.out.print(array[i] + " ");
      }
      System.out.println("]");
      new Scanner(System.in).nextLine();
      sort(array, middle + 1, right);

      // Une las mitades.
      System.out.print("Se uniran las mitades: [ ");
      for (int i = left; i <= middle; i++) {
        System.out.print(array[i] + " ");
      }
      System.out.print("] y [ ");
      for (int i = middle + 1; i <= right; i++) {
        System.out.print(array[i] + " ");
      }
      System.out.println("]");
      new Scanner(System.in).nextLine();
      merge(array, left, middle, right);
    }
  }

  // Método para fusionar las dos mitades.
  private static void merge(int[] array, int left, int middle, int right) {
    // Tamaños de los subarrays temporales.
    int n1 = middle - left + 1;
    int n2 = right - middle;

    System.out.println("El tamano del primer array es: " + n1);
    System.out.println("El tamano del segundo array es: " + n2);

    // Subarrays temporales.
    int[] L = new int[n1];
    int[] R = new int[n2];

    // Copia los datos a los arrays temporales.
    for (int i = 0; i < n1; i++) {
      L[i] = array[left + i];
    }
    for (int j = 0; j < n2; j++) {
      R[j] = array[middle + 1 + j];
    }

    System.out.print("\nSub-array izquierdo: ");
    for (int i : L) {
      System.out.print(i + " ");
    }

    System.out.print("\nSub-array derecho: ");
    for (int j : R) {
      System.out.print(j + " ");
    }

    new Scanner(System.in).nextLine();

    // Índices iniciales de los subarrays.
    int i = 0, j = 0;

    // Índice inicial del subarray mezclado.
    int k = left;

    // Ordenamiento y mezcla.
    while (i < n1 && j < n2) {
      System.out.println();
      if (L[i] <= R[j]) {
        System.out.println(L[i] + " es menor o igual que " + R[j]);
        array[k] = L[i];
        System.out.println("El valor del array[" + k + "] es: " + L[i]);
        i++;
      } else {
        System.out.println(L[i] + " es mayor que " + R[j]);
        array[k] = R[j];
        System.out.println("El valor del array[" + k + "] es: " + R[j]);
        j++;
      }
      new Scanner(System.in).nextLine();
      k++;
      System.out.print("Array resultante: [ ");
      for (int value = 0; value < k; value++) {
        System.out.print(array[value] + " ");
      }
      System.out.println("]");
    }

    System.out.println("\nSe copian los elementos restantes del sub-array izquierdo:");
    // Copiar los elementos restantes de L, si los hay.
    while (i < n1) {
      System.out.println("El valor del array[" + k + "] es: " + L[i]);
      array[k] = L[i];
      i++;
      k++;
    }

    System.out.println("\nSe copian los elementos restantes del sub-array derecho:");
    // Copiar los elementos restantes de R, si los hay.
    while (j < n2) {
      System.out.println("El valor del array[" + k + "] es: " + R[j]);
      array[k] = R[j];
      j++;
      k++;
    }
    System.out.println();
  }

  public static void main(String[] args) {
    int[] data = { 12, 11, 13, 7, 5, 6 };
    System.out.println("\nArray original:");
    for (int i : data) {
      System.out.print(i + " ");
    }
    sort(data, 0, data.length - 1);
    System.out.println("\nArray ordenado:");
    for (int i : data) {
      System.out.print(i + " ");
    }
  }
}