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

    
    public void bubbleSortPalo(Carta[] cartas) {
        boolean swapped;
        int passIndex = 0;
        do {
            swapped = false;
            for (int j = 0; j < cartas.length - 1 - passIndex; j++) {
                int current = cartas[j].getPalo() * 13 + cartas[j].getNumero();
                int next = cartas[j + 1].getPalo() * 13 + cartas[j + 1].getNumero();
                if (current > next) {
                    Carta temp = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = temp;
                    swapped = true;
                }
            }
            passIndex++;
        } while (swapped);
    }



}
