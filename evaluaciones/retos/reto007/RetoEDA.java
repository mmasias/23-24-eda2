package evaluaciones.retos.reto007;

import java.util.Scanner;

public class RetoEDA {
    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
         Scanner userInput = new Scanner(System.in);
         Carta[] cartas = baraja.getCartas();
         Sort sortingMethod = new Sort();

         System.out.println("¿Cómo desea ordenar las cartas?");
         System.out.println("1 - Por número");
         System.out.println("2 - Por palo");
         System.out.println("Introduzca la opción deseada");
         int chosenOption = userInput.nextInt();

         switch(chosenOption) {
            case 1:
                sortingMethod.selectionSortNumero(cartas);
                break;
            case 2:
                sortingMethod.bubbleSortPalo(cartas);
                break;
            default:
                System.out.println("No ha introducido una opción válida");
         }
         
        //
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}
