public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i]; 
            int j = i - 1;
            while (j >= 0 && array[j] > current) {
                System.out.println("Moviendo " + array[j] + " a la derecha"); 
                array[j + 1] = array[j]; // Desplaza el elemento hacia la derecha
                j--;
            }
            array[j + 1] = current; // Inserta el elemento en su lugar correcto
            System.out.println("Insertando " + current + " en su posición correcta");
            System.out.print("Array después de la iteración " + i + ": [");
            for (int k = 0; k <= i; k++) {
                System.out.print(array[k]);
                if (k < i) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
    
    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        sort(data);
        System.out.println("Array ordenado:");
        for (int value : data) {
            System.out.print(value + " ");
        }
    }
}