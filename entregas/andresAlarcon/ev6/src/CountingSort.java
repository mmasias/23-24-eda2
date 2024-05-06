public class CountingSort {

  public void sort(int[] array) {
    int length = array.length;
    // El arreglo de salida que tendrá los elementos ordenados
    int output[] = new int[length];

    // Encuentra el elemento mayor para determinar el rango del conteo
    int max = array[0];
    for (int i = 1; i < length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }

    // Arreglo de conteo para contar la frecuencia de cada elemento
    int count[] = new int[max + 1];

    // Paso 1: Contar la frecuencia de cada elemento en el arreglo original
    for (int i = 0; i < length; i++) {
      count[array[i]]++;
    }

    // Imprimir el arreglo de conteo inicial
    System.out.println("Arreglo de conteo inicial:");
    printArray(count);

    // Paso 2: Modificar el arreglo de conteo para almacenar las posiciones finales
    for (int i = 1; i <= max; i++) {
      count[i] += count[i - 1];
    }

    // Imprimir el arreglo de conteo modificado
    System.out.println("\nArreglo de conteo modificado (posiciones finales):");
    printArray(count);

    // Paso 3: Construir el arreglo de salida ordenado
    for (int i = length - 1; i >= 0; i--) {
      int currentElement = array[i];
      int positionInOutput = count[currentElement] - 1;
      output[positionInOutput] = currentElement;
      count[currentElement]--;

      // Imprimir detalles del proceso de ordenamiento
      System.out.println("\nIteración " + (length - i) + ":");
      System.out.println("Elemento actual: " + currentElement);
      System.out.println("Posición en arreglo de salida: " + positionInOutput);
      System.out.println("Arreglo de salida temporal:");
      printArray(output);
      System.out.println("Arreglo de conteo actualizado:");
      printArray(count);
    }

    // Copiar los elementos ordenados al arreglo original
    for (int i = 0; i < length; i++) {
      array[i] = output[i];
    }
  }

  // Método para imprimir un arreglo
  private void printArray(int[] array) {
    for (int num : array) {
      System.out.print(num + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) {
    CountingSort obj = new CountingSort();
    int[] data = { 4, 2, 2, 8, 3, 3, 1 };
    System.out.println("Array original:");
    obj.printArray(data);
    System.out.println("=".repeat(60));
    obj.sort(data);
    System.out.println("=".repeat(60));
    System.out.println("Array ordenado:");
    obj.printArray(data);
  }
}
