package entregas.DiegoBarraza.reto003;

import java.util.List;

class Libro extends Documento {
    private String isbn;

    public Libro(String titulo, List<String> autores, int añoPublicacion, String tipoDocumento, List<String> palabrasClave, String isbn) {
        super(titulo, autores, añoPublicacion, tipoDocumento, palabrasClave);
        this.isbn = isbn;
    }

    
    public String getIsbn() {
        return isbn;
    }
}
