abstract class Mazo {

    protected Carta[] cartas;
    protected int ultima;
    protected String titulo;

    public Mazo(int numeroCartas, String titulo) {
        ultima = 0;
        cartas = new Carta[numeroCartas];
        this.titulo = titulo;
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

    protected boolean vacia() {
        return ultima == 0;
    }

    protected Carta cima() {
        return cartas[ultima - 1];
    }

    protected Carta sacar() {
        ultima--;
        return cartas[ultima];
    }

    public void mostrar() {
        System.out.print(this.titulo + ": ");
        if (this.vacia()) {
            System.out.println("NO HAY CARTAS");
        } else {
            mostrarContenido();
            System.out.println();
        }
    }

    protected abstract void mostrarContenido();
}