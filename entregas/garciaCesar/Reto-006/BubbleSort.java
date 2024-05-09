public class BubbleSort {
    public static void main(String[] args) {
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original:");
        mostrarArray(data);
        System.out.println();
        sort(data);
        System.out.println();
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }

    public static void sort(int[] array) {
        int n = array.length;
        for (int i = 0; i < n - 1; i++) { // i es el número de pasadas completas
            for (int j = 0; j < n - 1; j++) { // j es el índice para comparar elementos adyacentes
                if (array[j] > array[j + 1]) {
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
            System.out.print("Fase " + (i + 1) + ": ");
            mostrarArray(array);
        }
    }
    /*Esta variante de Bubble Sort utiliza dos bucles anidados.
    En cada iteración de i, el algoritmo realiza un pase completo a través del arreglo.
    En cada comparación (j con j+1), si el elemento actual es mayor que el siguiente, intercambia los elementos.
    Muestra el estado del arreglo después de cada fase. */

    public static void sort2(int[] array) {
        boolean sorted = false;
        int passIndex = 0; // Para reducir el alcance del barrido en cada pasada
        while (!sorted) {
            sorted = true; // Se asume que el arreglo está ordenado
            for (int j = 0; j < array.length - 1 - passIndex; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    sorted = false; // Se encontró un desorden, se continua
                }
            }
            passIndex++;
            System.out.println("Fase " + passIndex + ": ");
            mostrarArray(array);
        }
    }
    /*Esta variante utiliza un bucle while con una bandera sorted para determinar si el arreglo está completamente ordenado.
    Realiza un pase completo a través del arreglo en cada iteración del bucle while.
    Si se realiza algún intercambio durante un pase, sorted se establece en false, lo que significa que el arreglo aún no está completamente ordenado.
    Muestra el estado del arreglo después de cada fase. */

    public static void sort3(int[] array) {
        boolean swapped;
        int passIndex = 0;
        do {
            swapped = false;
            for (int j = 0; j < array.length - 1 - passIndex; j++) {
                if (array[j] > array[j + 1]) {
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true; // Se registró un intercambio
                }
            }
            passIndex++;
            System.out.println("Fase " + passIndex + ": ");
            mostrarArray(array);
        } while (swapped); // Continuar mientras se realicen intercambios
    }
    /*Esta variante también utiliza un bucle do-while con una bandera swapped para determinar si se realizan intercambios durante un pase.
    Si no se realizan intercambios en un pase completo, significa que el arreglo está ordenado y el bucle do-while se detiene.
    Muestra el estado del arreglo después de cada fase. */

    public static void mostrarArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}