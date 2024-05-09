public class BubbleSort {
    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) { // i es el número de pasadas completas
            boolean intercambio = false;
            for (int j = 0; j < n - 1; j++) { // j es el índice para comparar elementos adyacentes
                int first = array[j];
                int second = array[j + 1];
                System.out.println("Comparando " + first + " con " + second);
                if (first > second) {
                    // Intercambio de elementos
                    int temp = first;
                    array[j] = second;
                    array[j + 1] = temp;
                    intercambio = true;
                    System.out.println("Intercambiando " + first + " con " + second);
                }
            }
            if (intercambio) {
                System.out.print("Estado actual del array: ");
                printArray(array);
            }
            if (!intercambio) {
                break;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println(); 
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
