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

    public void barajar() {
        Random aleatorio = new Random();
        for (int i = 0; i < 1000; i++) {
            int origen = aleatorio.nextInt(TOTAL_CARTAS);
            int destino = aleatorio.nextInt(TOTAL_CARTAS);
            Carta carta = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = carta;
        }
    }

    // Todos estan programados con bubble sort

    public void ordenarNumero() {
        for (int i = 0; i < ultima - 1; i++) {
            for (int j = 0; j < ultima - i - 1; j++) {
                if (cartas[j].getNumero() > cartas[j + 1].getNumero()) {
                    Carta temp = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = temp;
                }
            }
        }
    }

    public void ordenarPalo() {
        for (int i = 0; i < ultima - 1; i++) {
            for (int j = 0; j < ultima - i - 1; j++) {
                if (cartas[j].getPalo() > cartas[j + 1].getPalo()) {
                    Carta temp = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = temp;
                }
            }
        }
    }

    public void ordenarNumeroPalo() {
        for (int i = 0; i < ultima - 1; i++) {
            for (int j = 0; j < ultima - i - 1; j++) {
                if (cartas[j].getNumero() > cartas[j + 1].getNumero()) {
                    intercambiarCartas(j, j + 1);
                }
                else if (cartas[j].getNumero() == cartas[j + 1].getNumero() &&
                        cartas[j].getPalo() > cartas[j + 1].getPalo()) {
                    intercambiarCartas(j, j + 1);
                }
            }
        }
    }

    private void intercambiarCartas(int indice1, int indice2) {
        Carta temp = cartas[indice1];
        cartas[indice1] = cartas[indice2];
        cartas[indice2] = temp;
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
