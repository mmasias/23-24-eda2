import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        int x = 0;
        do{
        System.out.println("Si desea ordenar la baraja por palo presione: 1 \nSi desea ordenar la baraja por números presione: 2 ");
        Scanner sc = new Scanner(System.in);
        x = sc.nextInt();
        if (x==1) {
            Comparator<Carta> comparador = new Comparator<Carta>() {
                @Override
                public int compare(Carta o1, Carta o2) {
                    if (o1.igualPalo(o2)) {
                        if (o1.numero < o2.numero) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else {
                        if (o1.palo < o2.palo) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }
            };
            Carta[] array = baraja.cartas;
            boolean sorted = false;
            int passIndex = 0; // Para reducir el alcance del barrido en cada pasada
            while (!sorted) {
                sorted = true; // Se asume que el arreglo está ordenado
                for (int j = 0; j < array.length - 1 - passIndex; j++) {
                    if (comparador.compare(array[j], array[j + 1]) > 0) {
                        // Intercambio de elementos
                        Carta temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        sorted = false; // Se encontró un desorden, se continua

                    }
                }
                passIndex++;
            }
        } else if (x==2) {
            Comparator<Carta> comparador = new Comparator<Carta>() {
                @Override
                public int compare(Carta o1, Carta o2) {

                        if (o1.numero < o2.numero) {
                            return 1;
                        } else {
                            return -1;

                    }

                }
            };
            Carta[] array = baraja.cartas;
            boolean sorted = false;
            int passIndex = 0;
            while (!sorted) {
                sorted = true;
                for (int j = 0; j < array.length - 1 - passIndex; j++) {
                    if (comparador.compare(array[j], array[j + 1]) > 0) {
                        Carta temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                        sorted = false;

                    }
                }
                passIndex++;
            }

        } else {
            System.out.println("Debe introducir 1 o 2");

        }
    } while (x < 1 || x > 2);


        //
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}
