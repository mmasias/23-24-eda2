package evaluaciones.retos.reto006;

public class MergeSort {
// Método para dividir y fusionar el array
public static void sort(int[] array, int left, int right) {
    if (left < right) {
        int middle = (left + right) / 2;
        System.out.println("Punto medio del vector: " + middle);

        System.out.println("Dividiendo la primera mitad del vector...");
        sort(array, left, middle);
        System.out.println("Dividiendo la segunda mitad del vector...");
        sort(array, middle + 1, right);

        System.out.println("Fusionando las mitades del vector...");
        merge(array, left, middle, right);
    }
}

// Método para fusionar las dos mitades.
private static void merge(int[] array, int left, int middle, int right) {
    int n1 = middle - left + 1;
    int n2 = right - middle;
    System.out.println("Tamaño del subarray izquierdo: " + n1 + "; Tamaño del subarray derecho: " + n2);

    // Subarrays temporales.
    int[] L = new int[n1];
    int[] R = new int[n2];

    // Copia los datos a los arrays temporales.
    for (int i = 0; i < n1; i++) {
        L[i] = array[left + i];
        System.out.println("Copiando " + array[left + i] + " en el subarray izquierdo");
    }
    for (int j = 0; j < n2; j++) {
        R[j] = array[middle + 1 + j];
        System.out.println("Copiando " + array[middle + 1 + j] + " en el subarray derecho");
    }

    // Índices iniciales de los subarrays.
    int i = 0, j = 0;

    // Índice inicial del subarray mezclado.
    int k = left;

    System.out.println("Ordenando y mezclando los arrays...");
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            array[k] = L[i];
            i++;
        } else {
            array[k] = R[j];
            j++;
        }
        k++;
    }

    while (i < n1) {
        array[k] = L[i];
        System.out.println("Copiando " + L[i] + " del subarray izquierdo al subarray mezclado");
        i++;
        k++;
    }

    while (j < n2) {
        array[k] = R[j];
        System.out.println("Copiando " + R[j] + " del subarray derecho al subarray mezclado");
        j++;
        k++;
    }
}

public static void main(String[] args) {
    int[] data = { 12, 11, 13, 5, 6, 7 };
    System.out.println("Array original:");
    for (int i : data) {
        System.out.print(i + " ");
    }
    sort(data, 0, data.length - 1);
    System.out.println("\nArray ordenado:");
    for (int i : data) {
        System.out.print(i + " ");
    }
}
}
