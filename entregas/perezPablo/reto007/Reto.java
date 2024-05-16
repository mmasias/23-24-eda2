package reto007;

import java.util.Scanner;

class Reto {
    
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        System.out.println("Mostrando baraja desordenada");
        baraja.pintar();
        System.out.println("Escriba 1 para ordenar la baraja por palos o 2 por números");
        int opcion = new Scanner(System.in).nextInt();
        System.out.println("Ordenando la baraja");
        if (opcion == 1) {
            baraja.ordenarPorPalo();
        } else if (opcion == 2) {
            baraja.ordenarPorNumero();
        } else {
            System.out.println("Error");
            System.exit(1);
            
        }
        baraja.pintar();

    }
    
}
