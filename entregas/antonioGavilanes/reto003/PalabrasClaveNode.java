package antonioGavilanes.reto003;

public class PalabrasClaveNode {

    private PalabrasClave key;
    private PalabrasClaveNode next;

    public PalabrasClaveNode(PalabrasClave key) {
        this.key = key;
        this.next = null;
    }

    public PalabrasClave getkey() {
        return key;
    }

    public void setkey(PalabrasClave key) {
        this.key = key;
    }

    public PalabrasClaveNode getNext() {
        return next;
    }

    public void setNext(PalabrasClaveNode next) {
        this.next = next;
    }
}
