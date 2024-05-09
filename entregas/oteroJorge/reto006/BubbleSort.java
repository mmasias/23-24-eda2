package entregas.oteroJorge.reto006;

public class BubbleSort {
    public static void sort(int[] array) {
        boolean swapped;
        int passIndex = 0;
        
        do {
            swapped = false;
            System.out.println("Inicio de la pasada " + (passIndex + 1));

            for (int j = 0; j < array.length - 1 - passIndex; j++) {
                System.out.println("Comparando elementos en índices " + j + " y " + (j + 1));
                
                if (array[j] > array[j + 1]) {
                    // Intercambio de elementos
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true; // Se registró un intercambio
                    System.out.println("Se intercambiaron " + array[j] + " y " + array[j + 1]);
                }
            }

            if (swapped) {
                System.out.println("Estado del array después de la pasada " + (passIndex + 1) + ": " + arrayToString(array));
            } else {
                System.out.println("No se realizaron intercambios en la pasada " + (passIndex + 1));
            }
            
            passIndex++;
        } while (swapped); // Continuar mientras se realicen intercambios
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
        int[] data = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("Array original: " + arrayToString(data));
        
        sort(data);

        System.out.println("Array ordenado: " + arrayToString(data));
    }
}
