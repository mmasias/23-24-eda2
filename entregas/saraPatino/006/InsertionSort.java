public class InsertionSort {
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i]; // Selecciona el elemento actual para su inserción
            int j = i - 1; // Índice del elemento anterior al elemento actual

            // Buscar la posición correcta para insertar el elemento actual
            while (j >= 0 && array[j] > current) {
                array[j + 1] = array[j];  // Desplaza los elementos mayores que el actual hacia la derecha
                j--;

                // Paso a paso del desplazamiento
                System.out.println("Desplazamiento: " + (j + 1) + " <- " + (j + 2));
                printArray(array); // Imprimir el estado actual del arreglo
            }
            
            array[j + 1] = current; // Insertar el elemento actual en la posición correcta

            // Paso a paso de la inserción
            System.out.println("Inserción de " + current + " en la posición " + (j + 1));
            printArray(array); // Imprimir el estado actual del arreglo
        }
    }

    public static void main(String[] args) {
        int[] data = {22, 11, 99, 88, 9, 7, 42};
        System.out.println("Array original:");
        printArray(data); // Imprimir el arreglo original
        sort(data); // Llamar al método sort para ordenar el arreglo
        System.out.println("Array ordenado:");
        printArray(data); // Imprimir el arreglo ordenado
    }

    static void printArray(int array[]) {
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}