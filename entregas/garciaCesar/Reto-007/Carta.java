public class Carta {

    public int palo;
    public int numero;
    private boolean bocaArriba;

    private final String[] PALOS = { "Picas", "Treboles", "Diamantes", "Corazones" };
    private final String[] NUMEROS = { "A", "2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K" };

    private final Intervalo NEGROS = new Intervalo(0, 1);
    private final Intervalo ROJOS = new Intervalo(2, 3);

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
        System.out.print ("[" + numero + " " + palo + "]");
    }

    public void voltear() {
        bocaArriba = !bocaArriba;
    }

    public boolean esAs() {
        return numero==0;
    }

    public boolean igualPalo(Carta carta) {
        return this.palo == carta.palo;
    }

    public boolean siguiente(Carta carta) {
        return this.numero == carta.numero+1;
    }

    public boolean esRey() {
        return numero==12;
    }

    public boolean bocaArriba() {
        return bocaArriba;
    }

    public boolean distintoColor(Carta carta) {
        return this.rojo() && carta.negro() || this.negro() && carta.rojo();        
    }

    private boolean negro() {
        return NEGROS.incluye(this.palo);
    }

    private boolean rojo() {
        return ROJOS.incluye(this.palo);
    }
}