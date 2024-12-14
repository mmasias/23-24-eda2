public class Descarte {

    private Carta[] cartas;
    private int ultima;

    public Descarte() {
        ultima = 0;
        cartas = new Carta[52];
    }

    public void mostrar() {
        System.out.print("Descarte: ");
        if (this.vacia()) {
            System.out.println("No hay cartas en el descarte");
        } else {
            for (int i = 0; i < ultima; i++) {
                cartas[i].mostrar();
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

    public boolean vacia() {
        return ultima == 0;
    }

    public void moverA(Columna columna) {
        if (this.vacia()) {
            System.out.println("No se puede!");
        } else {
            Carta carta = this.sacar();
            if (columna.apilable(carta)) {
                columna.poner(carta);
            } else {
                this.poner(carta);
                System.out.println("No se puede!");
            }
        }
    }

    public Carta sacar() {
        ultima--;
        return cartas[ultima];
    }
}
