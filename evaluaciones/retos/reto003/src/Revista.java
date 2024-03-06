import java.util.ArrayList;

public class Revista extends Documento {

    public Revista(String titulo, ArrayList<String> autores, int anhoPublicacion, String tipoDocumento, ArrayList<String> palabrasClave) {
        super(titulo, autores, anhoPublicacion, tipoDocumento, palabrasClave);
    }

    public void setTipoDocumento(String tipoDocumento) {
        tipoDocumento = "Revista";
    }
}
