package evaluaciones.retos.reto006;

public class HeapSort {
    public static void sort(int array[]) {
        int n = array.length;
        System.out.println("El array es de " + n + " elementos");

        System.out.println("Reorganizando el arreglo...");
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        System.out.println("Extrayendo los elementos del montículo uno a uno...");
        for (int i = n - 1; i > 0; i--) {
            System.out.println("Moviendo la raiz actual " + array[i] + " al final");
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            System.out.println("Llamando a heapify para el montículo reducido...");
            heapify(array, i, 0);
        }
    }

    // Para convertir un subarreglo en un montículo
    static void heapify(int array[], int n, int i) {
        int largest = i; // Inicializar largest como raíz
        int l = 2 * i + 1; // izquierda = 2*i + 1
        int r = 2 * i + 2; // derecha = 2*i + 2
        System.out.println("Raíz (largest): " + largest + ", Hijo Izquierdo: " + l + ", Hijo Derecho: " + r);

        if (l < n && array[l] > array[largest])
            largest = l;
            System.out.println("El hijo izquierdo es mayor que la raíz: largest = " + largest);

        if (r < n && array[r] > array[largest])
            largest = r;
            System.out.println("El hijo derecho es mayor que la raíz: largest = " + largest);

        if (largest != i) {
            int swap = array[i];
            array[i] = array[largest];
            array[largest] = swap;

            System.out.println("largest " + largest + " , no es la raíz " + i + ". Llamado a heapify para el subárbol afectado...");
            heapify(array, n, largest);
        }
    }

    public static void main(String[] args) {
        int array[] = {12, 11, 13, 5, 6, 7};
        sort(array);
        System.out.println("Array ordenado:");
        for (int i : array) {
            System.out.print(i + " ");
        }
    }
}
