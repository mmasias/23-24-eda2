package Model;
import java.util.ArrayList;

public class Revista extends Documento {

    public Revista(String titulo, ArrayList<Autor> autores, int anhoPublicacion, String tipoDocumento, ArrayList<String> palabrasClave) {
        super(titulo, autores, anhoPublicacion, tipoDocumento, palabrasClave);
    }

   
}
