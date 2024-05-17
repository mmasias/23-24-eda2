package antonioGavilanes.reto003;

class DocumentoNode {

    private Documento doc;
    private DocumentoNode next;

    public DocumentoNode(Documento doc) {
        this.doc = doc;
        this.next = null;
    }

    public Documento getDoc() {
        return doc;
    }

    public void setDoc(Documento doc) {
        this.doc = doc;
    }

    public DocumentoNode getNext() {
        return next;
    }

    public void setNext(DocumentoNode next) {
        this.next = next;
    }

}
