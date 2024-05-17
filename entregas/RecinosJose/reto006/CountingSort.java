public class CountingSort {

    public void sort(int[] array) {
        int length = array.length;
        int output[] = new int[length];

        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max)
                max = array[i];
        }
        System.out.println("Elemento máximo encontrado: " + max);

        int count[] = new int[max + 1];

        for (int i = 0; i < length; i++) {
            count[array[i]]++;
        }
        System.out.print("Arreglo de conteo inicial: ");
        printArray(count);

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        System.out.print("Arreglo de conteo con posiciones acumuladas: ");
        printArray(count);

        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
        }

        System.out.print("Arreglo de salida construido: ");
        printArray(output);

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
        obj.sort(data);
        System.out.println("Array ordenado:");
        obj.printArray(data);
    }
}
