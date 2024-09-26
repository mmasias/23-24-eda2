import java.util.Scanner;

class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {


        Baraja baraja = new Baraja();

        baraja.imprime();
        Ordenacion ordenacion = null;
        ordenacion = new Ordenacion();
        System.out.println("¿Cómo quieres ordenar la baraja?");
        System.out.println("1. Por palo (♥️,♦️,♣️,♠️) sin importar Nºs"+"\n"+"2. Por palo (♠️,♣️,♦️,♥️) sin importar Nºs"+"\n"+"3. Por palo (♥️,♦️,♣️,♠️) y Nºs Ascendentes"+"\n"+"4. Por palo (♥️,♦️,♣️,♠️) y Nºs Descendentes");
        System.out.println("5. Por palo (♠️,♣️,♦️,♥️) y Nºs Ascendentes"+"\n"+"6. Por palo (♠️,♣️,♦️,♥️) y Nºs Descendentes"+"\n"+"7. Por Nºs Ascendentes sin importar palo"+"\n"+"8. Por Nºs Descendentes sin importar palo");
        System.out.println("9. Salir");
        Scanner lector = new Scanner(System.in);
        int opcion = lector.nextInt();
        if (opcion==9) {
                ordenacion.salir();
            }else if (opcion>=1 && opcion<=8) {
                do{

                    ordenacion = new Ordenacion();

                        switch (opcion) {
                            case 1 -> ordenacion.ordenarPorPalo(baraja, false);
                            case 2 -> ordenacion.ordenarPorPalo(baraja, true);
                            case 3 -> ordenacion.ordenarPorPalo2yNumero(baraja, true);
                            case 4 -> ordenacion.ordenarPorPalo2yNumero(baraja, false);
                            case 5 -> ordenacion.ordenarPorPalo1yNumero(baraja, false);
                            case 6 -> ordenacion.ordenarPorPalo1yNumero(baraja, true);
                            case 7 -> ordenacion.ordenarPorNumero(baraja, false);
                            default-> ordenacion.ordenarPorNumero(baraja, true);
                        }

                        baraja.imprime();
                        ordenacion.menu();
                        opcion = lector.nextInt();

                } while (opcion>=1 && opcion<=8);
        } else {
        System.out.println("Opción no válida, te paso la baraja sin ordenar");
            baraja.imprime();
        }
        lector.close();

        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}