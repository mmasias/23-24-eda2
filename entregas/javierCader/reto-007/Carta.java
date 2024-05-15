public class Carta {

    private int palo;
    private int numero;
    private boolean bocaArriba;

    private final String[] PALOS = { "♠️", "♣️", "♦️", "♥️" };
    private final String[] NUMEROS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K" };

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_BLACK = "\u001B[30m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_BLUE = "\u001B[34m";

    private final String[] PALOS_COLORS = { ANSI_BLACK, ANSI_GREEN, ANSI_RED, ANSI_BLUE };

    public Carta(int palo, int numero) {
        this.palo = palo;
        this.numero = numero;
        bocaArriba = false;
    }

    public void mostrar() {
        String numero = "?";
        String palo = "?";
        if (this.bocaArriba) {
            numero = NUMEROS[this.numero];
            palo = PALOS[this.palo];
        }
        System.out.print(PALOS_COLORS[this.palo] + "[" + numero + " " + palo + "]" + ANSI_RESET);
    }

    public void voltear() {
        bocaArriba = !bocaArriba;
    }

    public boolean esAs() {
        return numero == 0;
    }

    public boolean igualPalo(Carta carta) {
        return this.palo == carta.palo;
    }

    public boolean siguiente(Carta carta) {
        return this.numero == carta.numero + 1;
    }

    public boolean esRey() {
        return numero == 12;
    }

    public boolean bocaArriba() {
        return bocaArriba;
    }

    public boolean distintoColor(Carta carta) {
        return this.rojo() && carta.negro() || this.negro() && carta.rojo();
    }

    private boolean negro() {
        return this.palo == 0 || this.palo == 1;
    }

    private boolean rojo() {
        return this.palo == 2 || this.palo == 3;
    }

    public int getPalo() {
        return palo;
    }

    public int getNumero() {
        return numero;
    }
}
