package entregas.garciaDiego.Reto006;

public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            System.out.println("Iteración número " + i);
            int current = array[i];
            int j = i - 1;
            System.out.println("El número " + current + " se compara con el número " + array[j]);
            while (j >= 0 && array[j] > current) {
                
                System.out.println("El número " + current + " se mueve a la derecha");
                array[j + 1] = array[j];  // Desplaza el elemento hacia la derecha
                j--;
               
            }
            System.out.println(current + " se inserta en el lugar correcto");
            array[j + 1] = current; // Inserta el elemento en su lugar correcto
            printArray(array);
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

    public static void printArray(int[] array) {
        System.out.print("Array actualizado: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
