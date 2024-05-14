import java.util.Comparator;
import java.util.Scanner;

class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        Comparator<Carta> comparadorPalo = new Comparator<Carta>() {
            @Override
            public int compare(Carta o1, Carta o2) {
                if (o1.igualPalo(o2)) {
                    if (o1.numero < o2.numero) {
                        return 1;
                    } else
                        return -1;
                } else {
                    if (o1.palo < o2.palo) {
                        return 1;
                    } else
                        return -1;
                }
            }
        };
        Carta[] array = baraja.cartas;
        int n = array.length;

        Comparator<Carta> comparadorNumero = new Comparator<Carta>() {
            @Override
            public int compare(Carta o1, Carta o2) {
                if (o1.numero < o2.numero) {
                    return 1;
                } else
                    return -1;
            }
        };

        Comparator<Carta> comparadorMayorMenor = new Comparator<Carta>() {
            @Override
            public int compare(Carta o1, Carta o2) {
                if (o1.igualPalo(o2)) {
                    if (o1.numero > o2.numero) {
                        return 1;
                    } else
                        return -1;
                } else {
                    if (o1.palo < o2.palo) {
                        return 1;
                    } else
                        return -1;
                }
            }
        };
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        System.out.println("1. Ordenar de menor a mayor por palo");
        System.out.println("2. Ordenar de mayor a menor por palo");
        System.out.println("3. Ordenar por número");
        opcion = sc.nextInt();
        if (opcion == 1) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (comparadorPalo.compare(array[j], array[j + 1]) > 0) {
                        Carta temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }

            }
        } else if (opcion == 2) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (comparadorMayorMenor.compare(array[j], array[j + 1]) > 0) {
                        Carta temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        } else if (opcion == 3) {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (comparadorNumero.compare(array[j], array[j + 1]) > 0) {
                        Carta temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }

            }
        } else {
            System.out.println("Saliendo...");
            System.exit(0);
        }
        sc.close();
        //
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}