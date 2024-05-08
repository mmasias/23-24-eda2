package entregas.esparragozaVeronika;

public class BubbleSort {
    static int temp;
    public static void sort(int[] array) {
        boolean sorted = false;
        int passIndex = 0; // Para reducir el alcance del barrido en cada pasada
        while (!sorted) {
            sorted = true; // Se asume que el arreglo está ordenado
            for (int j = 0; j < array.length - 1 - passIndex; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sorted = false; // Se encontró un desorden, se continua
                } else {
                    System.out.println("\u001B[34m" + "Terminamos con el numero: " + temp);
                }

                System.out.println("Array en proceso:" + "\u001B[0m");
                for (int i = 0; i < array.length; i++) {
                    if (temp != 0 && array[i] == temp) {
                        System.out.print("\033[31m" + array[i] + " ");
                    } else {
                        System.out.print("\033[38;5;220m" + array[i] + " ");
                    }
                }
                System.out.println("\u001B[0m");
            }
            passIndex++;
        }
    }

    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 110, 54, 11, 90};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
