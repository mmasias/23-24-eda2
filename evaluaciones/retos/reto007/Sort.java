package evaluaciones.retos.reto007;

public class Sort {


    public void selectionSortNumero(Carta[] cartas) {
        int startIndex = 0;
        while(startIndex < cartas.length - 1) {
            int minIndex = startIndex;
            for (int j = startIndex + 1; j < cartas.length; j++) {
                if (cartas[j].getNumero() < cartas[minIndex].getNumero()) {
                    minIndex = j;
                }
            }
            Carta temp = cartas[minIndex];
            cartas[minIndex] = cartas[startIndex];
            cartas[startIndex] = temp;
            startIndex++;
        }
    }

}
