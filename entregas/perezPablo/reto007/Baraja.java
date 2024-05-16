package reto007;

import java.util.Arrays;
import java.util.Random;
import java.util.Comparator;

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

    public void ordenarPorPalo() {
        Arrays.sort(cartas, new Comparator<Carta>() {
            @Override
            public int compare(Carta carta1, Carta carta2) {
                if(carta1.getPalo() == carta2.getPalo()) {
                    return Integer.compare(carta1.getNumero(), carta2.getNumero());
                } else {
                    return Integer.compare(carta1.getPalo(), carta2.getPalo());
                }
            }
        });
    }
    public void ordenarPorNumero() {
        Arrays.sort(cartas, new Comparator<Carta>() {
            @Override
            public int compare(Carta carta1, Carta carta2) {
                if(carta1.getNumero() == carta2.getNumero()) {
                    return Integer.compare(carta1.getPalo(), carta2.getPalo());
                } else {
                    return Integer.compare(carta1.getNumero(), carta2.getNumero());
                }
            }
        });
    }
    public void pintar() {
        if (this.vacia()) {
            System.out.println("No hay cartas en la baraja");
        } else {
            for (int i = 0; i < TOTAL_CARTAS; i++) {
                cartas[i].mostrar();
                System.out.print(" ");
                if ((i + 1) % 13 == 0) { 
                    System.out.println();
                }
            }
        }
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

}