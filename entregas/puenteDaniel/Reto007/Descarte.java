package 23-24-eda2.entregas.puenteDaniel.Reto007;

public class Descarte {

    private Carta[] cartas;
    private int ultima;

    public Descarte() {
        this.ultima = 0;
        cartas = new Carta[52 - 28];
    }

    public void mostrar() {
        System.out.print("Descarte: ");
        if (this.vacia()) {
            System.out.println("No hay cartas en el Descarte");
        } else {
            int primeraVisible = ultima - 3;
            if (primeraVisible < 0) {
                primeraVisible = 0;
            }
            for (int i = primeraVisible; i < ultima; i++) {
                cartas[i].mostrar();
            }
            System.out.println();
        }
    }

    private boolean vacia() {
        return ultima == 0;
    }

    public void moverA(Palo palo) {
        if (this.vacia()) {
            System.out.println("No hay cartas en el descarte.");
        } else {
            Carta carta = this.sacar();
            if (palo.apilable(carta)) {
                palo.poner(carta);
            } else {
                System.out.println("Jugada inválida.");
            }
        }
    }

    private Carta sacar() {
        ultima--;
        return cartas[ultima];
    }

    public void moverA(Columna columna) {
        if (this.vacia()) {
            System.out.println("No se puede mover");
        } else {
            Carta carta = this.sacar();
            if (columna.apilable(carta)) {
                columna.poner(carta);
            } else {
                System.out.println("No se puede");
            }
        }
    }

    public void voltear(Baraja baraja) {
        if (this.vacia() || !baraja.vacia()) {
            System.out.println("No se puede voltear!");
        } else {
            while (!this.vacia()) {
                Carta carta = this.sacar();
                carta.voltear();
                baraja.poner(carta);
            }
        }
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }
}