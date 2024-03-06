import java.util.ArrayList;

public class Libro extends Documento {

    public Libro(String titulo, ArrayList<String> autores, int anhoPublicacion, String tipoDocumento, ArrayList<String> palabrasClave) {
        super(titulo, autores, anhoPublicacion, tipoDocumento, palabrasClave);
    }

    public void setTipoDocumento(String tipoDocumento) {
        tipoDocumento = "Libro";
    }

    
}
