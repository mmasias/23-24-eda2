import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Baraja {

    private Carta[] cartas;

    private final int PALOS = 4;
    private final int NUMEROS = 13;
    private final int TOTAL_CARTAS = PALOS * NUMEROS;

    private int ultima;

    public Baraja() {
        ultima = 0;
        cartas = new Carta[TOTAL_CARTAS];
        for (int palo = 0; palo < PALOS; palo++) {
            for (int numero = 0; numero < NUMEROS; numero++) {
                this.poner(new Carta(palo, numero));
            }
        }
        this.barajar();
    }

    private void barajar() {
        Random aleatorio = new Random();
        for (int i = 0; i < 1000; i++) {
            int origen = aleatorio.nextInt(TOTAL_CARTAS);
            int destino = aleatorio.nextInt(TOTAL_CARTAS);
            Carta carta = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = carta;
        }
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

    public void mostrar() {
        System.out.print("BARAJA: ");
        if (this.vacia()) {
            System.out.println("No hay cartas en la baraja");
        } else {
            Carta carta = this.cima();
            carta.mostrar();
            System.out.println();
        }
    }

    private Carta cima() {
        return cartas[ultima - 1];
    }

    public void moverA(Descarte descarte) {
        if (this.vacia()) {
            System.out.println("¡No hay cartas en la baraja!");
        } else {
            int contador = 3;
            while (contador > 0 && !this.vacia()) {
                Carta carta = this.sacar();
                carta.voltear();
                descarte.poner(carta);
                contador--;
            }
        }
    }

    public Carta sacar() {
        ultima--;
        return cartas[ultima];
    }

    public boolean vacia() {
        return ultima == 0;
    }


    public void ordenarPorNumero() {
        Arrays.sort(cartas, new Comparator<Carta>() {
            @Override
            public int compare(Carta carta1, Carta carta2) {
                Integer numero1 = carta1.numero;
                Integer numero2 = carta2.numero;
                return numero1.compareTo(numero2);
            }
        });
    }

    public void ordenarPorPalo() {
        Arrays.sort(cartas, new Comparator<Carta>() {
            @Override
            public int compare(Carta carta1, Carta carta2) {
                if (!carta1.bocaArriba() && carta2.bocaArriba()) {
                    return -1;
                } else if (carta1.bocaArriba() && !carta2.bocaArriba()) {
                    return 1;
                } else {
                    int palo1 = carta1.palo;
                    int palo2 = carta2.palo;
                    if (palo1 != palo2) {
                        return palo1 - palo2;
                    } else {
                        Integer numero1 = carta1.numero;
                        Integer numero2 = carta2.numero;
                        return numero1.compareTo(numero2);
                    }
                }
            }
        });

        int i = 0;
        while (i < cartas.length) {
            int j = i + 1;
            while (j < cartas.length && cartas[j].palo == cartas[i].palo) {
                j++;
            }
            Arrays.sort(cartas, i, j, new Comparator<Carta>() {
                @Override
                public int compare(Carta carta1, Carta carta2) {
                    Integer numero1 = carta1.numero;
                    Integer numero2 = carta2.numero;
                    return numero1.compareTo(numero2);
                }
            });
            i = j;
        }
    }


}
