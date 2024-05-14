import java.util.Scanner;

class RetoEDA {

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cómo quieres ordenar la baraja? (1: por número, 2: por palo)");
        int orden = sc.nextInt();
        baraja.ordenar(orden);
        //
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}
