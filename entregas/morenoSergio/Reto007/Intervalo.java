public class Intervalo {

    private int inicio;
    private int fin;

    public Intervalo(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    public boolean incluye(int valor) {
        return valor >= inicio && valor <= fin;
    }
}
