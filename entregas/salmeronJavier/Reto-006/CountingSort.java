public class CountingSort {
    public void sort(int[] array) {
        int length = array.length;
        int[] output = new int[length];

        int max = array[0];
        for (int i = 1; i < length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("Máximo valor en el array: " + max);

        int[] count = new int[max + 1];

        for (int i = 0; i < length; i++) {
            count[array[i]]++;
        }
        System.out.print("Frecuencias iniciales: ");
        for (int num : count) {
            System.out.print(num + " ");
        }
        System.out.println();

        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }
        System.out.print("Frecuencias acumuladas: ");
        for (int num : count) {
            System.out.print(num + " ");
        }
        System.out.println();
        for (int i = length - 1; i >= 0; i--) {
            output[count[array[i]] - 1] = array[i];
            count[array[i]]--;
            System.out.print("Construcción del array de salida: ");
            for (int num : output) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < length; i++) {
            array[i] = output[i];
        }
        System.out.print("Array final ordenado: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CountingSort obj = new CountingSort();
        int[] data = {4, 2, 2, 8, 3, 3, 1};
        System.out.print("Array original: ");
        for (int num : data) {
            System.out.print(num + " ");
        }
        System.out.println("\nComenzando el ordenamiento...");
        obj.sort(data);
        System.out.println("Array ordenado:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }
}
