package entregas.garciaDiego.Reto006;

public class BubbleSort {
    public static void sort(int[] array) {
        boolean sorted = false;
        int passIndex = 0; // Para reducir el alcance del barrido en cada pasada
        while (!sorted) {
            sorted = true; // Se asume que el arreglo está ordenado
            for (int j = 0; j < array.length - 1 - passIndex; j++) {
                if (array[j] > array[j + 1]) {
                    System.out.println("Intercambio de los elementos: " + array[j] + " pasa a la derecha de " +  array[j + 1]);
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    System.out.println("Continua porque esta en desorden");
                    sorted = false; 
                }
            }
            passIndex++;
            System.out.println("Numero de pasos realizados: " + passIndex);
        }
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
