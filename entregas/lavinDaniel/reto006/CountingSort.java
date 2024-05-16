package entregas.lavinDaniel.reto006;
public class CountingSort {

    public void sort(int[] array) {
        int length = array.length;
        int output[] = new int[length];

        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        int count[] = new int[max + 1];

        for (int i = 0; i < length; i++) {
            count[array[i]]++;
        }

        System.out.println("Arreglo de conteo inicial:");
        printArray(count);

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        System.out.println("\nArreglo de conteo modificado (posiciones finales):");
        printArray(count);

        for (int i = length - 1; i >= 0; i--) {
            int currentElement = array[i];
            int positionInOutput = count[currentElement] - 1;
            output[positionInOutput] = currentElement;
            count[currentElement]--;

            System.out.println("\nIteración " + (length - i) + ":");
            System.out.println("Elemento actual: " + currentElement);
            System.out.println("Posición en arreglo de salida: " + positionInOutput);
            System.out.println("Arreglo de salida temporal:");
            printArray(output);
            System.out.println("Arreglo de conteo actualizado:");
            printArray(count);
        }

        for (int i = 0; i < length; i++) {
            array[i] = output[i];
        }
    }

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