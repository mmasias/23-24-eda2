import java.util.Scanner;

public class CountingSort {
  public void sort(int[] array) {
    System.out.println();
    int length = array.length;
    // El arreglo de salida que tendrá los elementos ordenados
    int output[] = new int[length];

    // Encuentra el elemento mayor para saber el rango
    int max = array[0];
    for (int i = 1; i < length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }

    // Arreglo de conteo
    int count[] = new int[max + 1];

    // Almacenar el conteo de cada elemento
    System.out.println("Se contara la cantidad de veces que se repite cada elemento");
    for (int i = 0; i < length; i++) {
      count[array[i]]++;
      System.out.println("El elemento: " + array[i] + " se repite " + count[array[i]] + " veces");
    }

    System.out.print("El array de conteo es: [ ");
    for (int j : count) {
      System.out.print(count[j] + " ");
    }
    System.out.println("]");
    new Scanner(System.in).nextLine();

    // Cambiar count[i] para que count[i] contenga la posición actual
    // de este elemento en output[]
    System.out.println("Se sumaran la cantidad de elementos que preceden a cada indice del array de salida");
    for (int i = 1; i < count.length; i++) {
      count[i] += count[i - 1];
    }

    System.out.print("El array de conteo ahora es: [ ");
    for (int i = 1; i < count.length; i++) {
      System.out.print(count[i] + " ");
    }
    System.out.println("]");
    new Scanner(System.in).nextLine();

    System.out.println("Para crear el array de salida se recorrera el array de entrada en orden inverso");

    // Construir el arreglo de salida
    for (int i = length - 1; i >= 0; i--) {
      System.out.println("Se posicionara el valor: " + array[i]);
      output[count[array[i]] - 1] = array[i];
      count[array[i]]--;
      System.out.print("El array de salida es: [");
      for (int j = 0; j < output.length; j++) {
        System.out.print(output[j] + " ");
      }
      System.out.println("]");
      System.out.print("El array de conteo es: [ ");
      for (int k = 0; k < count.length; k++) {
        System.out.print(count[k] + " ");
      }
      System.out.println("]");
      new Scanner(System.in).nextLine();
    }

    // Copiar los elementos ordenados al arreglo original
    for (int i = 0; i < length; i++) {
      array[i] = output[i];
    }
  }

  public static void main(String[] args) {
    CountingSort obj = new CountingSort();
    int[] data = { 4, 2, 2, 8, 3, 3, 1 };
    obj.sort(data);
    System.out.println("Array ordenado:");
    for (int num : data) {
      System.out.print(num + " ");
    }
  }
}