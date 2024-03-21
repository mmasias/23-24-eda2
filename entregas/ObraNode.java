public class ObraNode {
    
    private Obra obra;
    private ObraNode next;

    public ObraNode(Obra documento) {
        this.obra = documento;
        this.next = null;
    }

    public Obra getObra() {
        return obra;
    }

    public void setObra(Obra obra) {
        this.obra = obra;
    }

    public ObraNode getNext() {
        return next;
    }

    public void setNext(ObraNode next) {
        this.next = next;
    }
}

