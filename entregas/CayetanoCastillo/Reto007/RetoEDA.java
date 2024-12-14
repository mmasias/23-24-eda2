package entregas.CayetanoCastillo.Reto007;


import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RetoEDA {

    private static Baraja baraja;

    public static void main(String[] args) {

        baraja = new Baraja();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la ordenacion de cartas deseada:");
        System.out.println("1. Ordenar por palo");
        System.out.println("2. Ordenar por número");
        int eleccion = scanner.nextInt();

        Carta[] cartas = new Carta[52];
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = baraja.sacar();
        }


        switch (eleccion) {
            case 1:
                Arrays.sort(cartas, (c1, c2) -> {
                    if (c1.getPalo() != c2.getPalo()) {
                        return Integer.compare(c1.getPalo(), c2.getPalo());
                    } else {
                        return Integer.compare(c1.getNumero(), c2.getNumero());
                    }
                });
                break;
            case 2:
                Arrays.sort(cartas, Comparator.comparingInt(Carta::getNumero));
                break;
            default:
                System.out.println("Selección inválida.");
                return;
        }

        System.out.println("Cartas ordenadas:");
        for (Carta carta : cartas) {
            carta.voltear();
            carta.mostrar();
            System.out.println();
        }

        scanner.close();
    }
}