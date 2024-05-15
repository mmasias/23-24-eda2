package evaluaciones.retos.reto007;

public class Sort {

    public void insertionSort (Carta[] cartas) {
        for (int i = 1; i < cartas.length; i++) {
            int current = cartas[i].getNumero();
            int j = i - 1;  
            while(j >= 0 && cartas[j].getNumero() > current) {
                cartas[j + 1] = cartas[j];
                j--;
            }
            cartas[j + 1] = cartas[i];
        }
    }

}
