package antonioGavilanes.reto003;

import java.util.Scanner;

class Usuario {

    private String name;
    private DocumentoNode first;

    public Usuario(String name) {
        this.name = name;
        this.first = null;
    }

    private void addDoc(Documento food) {
        DocumentoNode newDocumentoNode = new DocumentoNode(food);
        if (first == null) {
            first = newDocumentoNode;
        } else {
            DocumentoNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newDocumentoNode);
        }
    }

    private void createDoc() {
    }
}