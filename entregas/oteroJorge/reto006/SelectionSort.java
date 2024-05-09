package entregas.oteroJorge.reto006;

public class SelectionSort {
    public static void sort(int[] array) {
        int startIndex = 0;
        
        while (startIndex < array.length - 1) {
            System.out.println("Inicio de la pasada " + (startIndex + 1) + ": " + arrayToString(array));
            
            int minIndex = startIndex;
            
            // Encuentra el índice del elemento más pequeño en el subarray no ordenado
            for (int j = startIndex + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Intercambio del elemento mínimo encontrado con el elemento en startIndex
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;
            
            System.out.println("Se intercambiaron " + array[startIndex] + " y " + array[minIndex]);
            
            startIndex++;
        }
        
        System.out.println("Array ordenado: " + arrayToString(array));
    }

    public static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i != array.length - 1) {
                sb.append(", ");
            }
        }
        return "[" + sb.toString() + "]";
    }

    public static void main(String[] args) {
        int[] data = {29, 20, 73, 34, 64};
        System.out.println("Array original: " + arrayToString(data));
        
        sort(data);
    }
}


