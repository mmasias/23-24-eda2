import java.util.Scanner;

class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        Scanner scanner = new Scanner(System.in);
    
        System.out.println("Como quieres ordenar la baraja?");
        System.out.println("1. Aleatorio");
        System.out.println("2. Ordenada por número");
        System.out.println("3. Ordenada por palo");
        System.out.println("4. Ordenada por número y palo");
        int option = scanner.nextInt();
        switch (option) {
            case 1:
                baraja.barajar();
                break;
            case 2:
                baraja.ordenarNumero();
                break;
            case 3:
                baraja.ordenarPalo();
                break;
            case 4:
                baraja.ordenarNumeroPalo();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        scanner.close();
            
        //
        Carta carta;

        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}
