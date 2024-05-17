import java.util.Scanner;

class RetoEDA {

  public static void main(String[] args) {

    Baraja baraja = new Baraja();
    Ordenador ordenadorDeCartas = new Ordenador();
    Scanner scanner = new Scanner(System.in);

    imprimirMenu();
    int input = scanner.nextInt();

    switch (input) {
      case 1:
        ordenadorDeCartas.ordenarPorNumero(baraja);
        break;
      case 2:
        ordenadorDeCartas.ordenarPorPalo(baraja);
        break;
      default:
        break;
    }

    Carta carta;
    do {
      carta = baraja.sacar();
      carta.voltear();
      carta.mostrar();
    } while (!baraja.vacia());
  }

  private static void imprimirMenu() {
    System.out.println("Opciones: ");
    System.out.println("1. Ordenar por numero");
    System.out.println("2. Ordenar por palo");
    System.out.print("Ingrese una opcion: ");
  }
}