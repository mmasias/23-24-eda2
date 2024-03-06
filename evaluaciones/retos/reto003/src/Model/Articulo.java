package Model;
import java.util.ArrayList;

public class Articulo extends Documento {

    public Articulo (String titulo, ArrayList<Autor> autores, int anhoPublicacion, String tipoDocumento, ArrayList<String> palabrasClave) {
        super(titulo, autores, anhoPublicacion, tipoDocumento, palabrasClave);
    }

   
}
