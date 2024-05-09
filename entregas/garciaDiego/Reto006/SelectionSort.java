package entregas.garciaDiego.Reto006;

public class SelectionSort {
    public static void sort(int[] array) {
        int startIndex = 0;
        while (startIndex < array.length - 1) {
            int minIndex = startIndex;
            for (int j = startIndex + 1; j < array.length; j++) {
                System.out.println("Se busca el elemento más pequeño del array");
                if (array[j] < array[minIndex]) {
                    minIndex = j; // Encuentra el índice del elemento más pequeño
                    System.out.println("El elemento más pequeño del array se encuentraen la posicion: "+ minIndex +" y es: " + array[minIndex]);
              
                }
            }
            // Intercambio del elemento mínimo encontrado con el elemento en startIndex
            System.out.println("Intercambio de los elementos " + array[startIndex] + " y " + array[minIndex]);
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;
            startIndex++;
            System.out.println("Numero de pasos realizados: " + startIndex);
        }
    }

    public static void main(String[] args) {
        int[] data = {29, 20, 73, 34, 64};
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}
