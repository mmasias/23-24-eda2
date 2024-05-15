//import java.util.Comparator;
import java.util.Scanner;

class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        Carta carta1;
        Carta[] cartasOrdenadas = new Carta[52]; 
        boolean sorted = false;
        int passIndex = 0;

        for(int i=0;i<cartasOrdenadas.length;i++){
            carta1 = baraja.sacar();
            cartasOrdenadas[i] = carta1;
        }

        while (!sorted) {
            sorted = true; // Se asume que el arreglo está ordenado
            for (int j = 0; j < cartasOrdenadas.length - 1 - passIndex; j++) {
                if (cartasOrdenadas[j].getNumero() > cartasOrdenadas[j + 1].getNumero()) {
                    System.out.println("Intercambio de los elementos: " + cartasOrdenadas[j] + " pasa a la derecha de " +  cartasOrdenadas[j + 1]);
                    Carta temp = cartasOrdenadas[j];
                    cartasOrdenadas[j] = cartasOrdenadas[j + 1];
                    cartasOrdenadas[j + 1] = temp;
                    System.out.println("Continua porque esta en desorden");
                    sorted = false; 
                }
            }
            passIndex++;
            System.out.println("Numero de pasos realizados: " + passIndex);
        }

        for (int i = 0; i < cartasOrdenadas.length; i++) {
            cartasOrdenadas[i].voltear();
            cartasOrdenadas[i].mostrar();
        }
        //
/*
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());

        */
    }
}