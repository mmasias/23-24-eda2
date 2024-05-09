public class SelectionSort {
    public static void sort(int[] array) {
        //Genera el indice inicial
        int startIndex = 0;

        while (startIndex < array.length - 1) {
            int minIndex = startIndex;
            //Recorre el array con el objetivo de encontrar el índice del elemento más pequeño
            for (int j = startIndex + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            //Intercambia el elemento más pequeño con el primer elemento del array
            int temp = array[minIndex];
            array[minIndex] = array[startIndex];
            array[startIndex] = temp;
            startIndex++;
        }
    }

    public static void main(String[] args) {
        //Se establece el array sobre el que se va a ejecurar el algoritmo
        int[] data = {29, 20, 73, 34, 64};
        //Se aplica SORT sobre el array y se imprime el resultado
        sort(data);
        System.out.println("Array ordenado:");
        for (int i : data) {
            System.out.print(i + " ");
        }
    }
}