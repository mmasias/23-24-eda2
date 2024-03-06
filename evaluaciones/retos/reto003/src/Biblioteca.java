import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Documento> documentos = new ArrayList<>();

    public Biblioteca(ArrayList<Documento> documentos) {
        this.documentos = documentos;
    }

    public Documento buscarDocumentoNombre(String nombreDocumento) {
        for(Documento d : documentos) {
            if(d.equals(nombreDocumento)){
                return d;
            }
        }
        return null;
    }

    


}
