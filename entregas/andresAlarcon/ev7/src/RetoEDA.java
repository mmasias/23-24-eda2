import java.util.Scanner;

public class RetoEDA {

    private static Baraja baraja;

    public static void main(String[] args) {

        baraja = new Baraja();

        // Solicita al usuario cómo ordenar las cartas
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione cómo desea ordenar las cartas:");
        System.out.println("1. Ordenar por palo");
        System.out.println("2. Ordenar por número");
        System.out.print("Ingrese su elección (1 o 2): ");
        int eleccion = scanner.nextInt();

        // Asumiendo que hay 52 cartas en la baraja
        Carta[] cartas = new Carta[52];
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = baraja.sacar();
        }

        if (eleccion == 1) {
            CartaOrdenador.ordenarPorPalo(cartas);
        } else {
            CartaOrdenador.ordenarPorNumero(cartas);
        }

        // Devolver las cartas ordenadas a la baraja
        for (Carta carta : cartas) {
            baraja.poner(carta);
        }

        // Mostrar las cartas ordenadas
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());

        scanner.close();
    }
}
