package Model;
import java.util.ArrayList;

public class PaperCientifico extends Documento {

    public PaperCientifico(String titulo, ArrayList<Autor> autores, int anhoPublicacion, String tipoDocumento, ArrayList<String> palabrasClave) {
        super(titulo, autores, anhoPublicacion, tipoDocumento, palabrasClave);
    }

    
}
