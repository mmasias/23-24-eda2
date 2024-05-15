//import java.util.Comparator;
import java.util.Scanner;

class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        
        Carta carta1;
        Carta[] cartasOrdenadasNumero = new Carta[52]; 
        boolean sorted = false;
        int passIndex = 0;

        for(int i=0;i<cartasOrdenadasNumero.length;i++){
            carta1 = baraja.sacar();
            cartasOrdenadasNumero[i] = carta1;
        }

        while (!sorted) {
            sorted = true; // Se asume que el arreglo está ordenado
            for (int j = 0; j < cartasOrdenadasNumero.length - 1 - passIndex; j++) {
                if (cartasOrdenadasNumero[j].getNumero() > cartasOrdenadasNumero[j + 1].getNumero()) {
                    System.out.println("Intercambio de los elementos: " + cartasOrdenadasNumero[j] + " pasa a la derecha de " +  cartasOrdenadasNumero[j + 1]);
                    Carta temp = cartasOrdenadasNumero[j];
                    cartasOrdenadasNumero[j] = cartasOrdenadasNumero[j + 1];
                    cartasOrdenadasNumero[j + 1] = temp;
                    System.out.println("Continua porque esta en desorden");
                    sorted = false; 
                }
            }
            passIndex++;
            System.out.println("Numero de pasos realizados: " + passIndex);
        }

        for (int i = 0; i < cartasOrdenadasNumero.length; i++) {

            baraja.poner(cartasOrdenadasNumero[i]);
        }
        
        Carta[] cartasOrdenadasPalo = new Carta[52];
        sorted = false;
        passIndex = 0;
        Baraja baraja2 = new Baraja();



        for(int i=0;i<cartasOrdenadasPalo.length;i++){
            carta1 = baraja2.sacar();
            cartasOrdenadasPalo[i] = carta1;
        }

        while (!sorted) {
            sorted = true; // Se asume que el arreglo está ordenado
            for (int j = 0; j < cartasOrdenadasPalo.length - 1 - passIndex; j++) {
                if (cartasOrdenadasPalo[j].getPalo() > cartasOrdenadasPalo[j + 1].getPalo()) {
                    System.out.println("Intercambio de los elementos: " + cartasOrdenadasPalo[j] + " pasa a la derecha de " +  cartasOrdenadasPalo[j + 1]);
                    Carta temp = cartasOrdenadasPalo[j];
                    cartasOrdenadasPalo[j] = cartasOrdenadasPalo[j + 1];
                    cartasOrdenadasPalo[j + 1] = temp;
                    System.out.println("Continua porque esta en desorden");
                    sorted = false; 
                }
            }
            passIndex++;
            System.out.println("Numero de pasos realizados: " + passIndex);
        }

        for (int i = 0; i < cartasOrdenadasPalo.length; i++) {
            baraja2.poner(cartasOrdenadasPalo[i]);
        }

        //
        Carta carta;
        System.out.println("\n");
        System.out.println("\u001B[34mBARAJA ORDENADA POR NUMEROS\u001B[0m");
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());

        System.out.println("\n");
        System.out.println("\u001B[34mBARAJA ORDENADA POR PALOS\u001B[0m");
        do {
            carta = baraja2.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja2.vacia());

        
    }
}