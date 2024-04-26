package entregas.DiegoBarraza.reto003;

import java.util.List;

class Revista extends Documento {
    private int numero;

    public Revista(String titulo, List<String> autores, int añoPublicacion, String tipoDocumento, List<String> palabrasClave, int numero) {
        super(titulo, autores, añoPublicacion, tipoDocumento, palabrasClave);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }
}

