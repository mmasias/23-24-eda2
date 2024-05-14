import java.util.Scanner;

class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        Ordenacion ordenacion = new Ordenacion();
        System.out.println("¿Cómo quieres ordenar la baraja?");
        System.out.println("1. Por palo (♥️,♦️,♣️,♠️) sin importar Nºs");
        System.out.println("2. Por palo (♠️,♣️,♦️,♥️) sin importar Nºs");
        System.out.println("3. Por palo (♥️,♦️,♣️,♠️) y Nºs Ascendentes");
        System.out.println("4. Por palo (♥️,♦️,♣️,♠️) y Nºs Descendentes");
        System.out.println("5. Por palo (♠️,♣️,♦️,♥️) y Nºs Ascendentes");    
        System.out.println("6. Por palo (♠️,♣️,♦️,♥️) y Nºs Descendentes");
        System.out.println("7. Por Nºs Ascendentes sin importar palo");
        System.out.println("8. Por Nºs Descendentes sin importar palo");
        int opcion = new Scanner(System.in).nextInt();
            switch (opcion) {
                case 1:
                    ordenacion.ordenarPorPalo1(baraja);
                    break;
                case 2:
                    ordenacion.ordenarPorPalo2(baraja);
                    break;
                case 3:
                    ordenacion.ordenarPorPalo1yNumeroAsc(baraja);
                    break;
                case 4:
                    
                    break;
                case 5:
                        
                    break;
                case 6:
                    
                    break;
                case 7:
                    ordenacion.ordenarPorNumeroAsc(baraja);
                    break;
                case 8:
                    ordenacion.ordenarPorNumeroDesc(baraja);
                    break;
                default:
                    System.out.println("Opción no válida, te paso la baraja sin ordenar");
                    break;
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