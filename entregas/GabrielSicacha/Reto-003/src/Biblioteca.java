import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Documento> documentos;
    private Gestionador gestionador;

    public Biblioteca() {
        documentos = new ArrayList<>();
        gestionador = new Gestionador(this);
    }

    public void anadirDocumento(Documento documento){
        documentos.add(documento);
        System.out.println("Documento añadido!");
    }

    public void borrarDocumento(String titulo){
        if(buscarPorTitulo(titulo)==null){
            System.out.println("No existe tal documento en la biblioteca");
        } else {
            documentos.removeIf(documento -> documento.getTitulo().equalsIgnoreCase(titulo));
            System.out.println("Documento borrado");
        }
    }

    public Documento buscarPorTitulo(String titulo){
        for (Documento doc : documentos) {
            if(doc.getTitulo().equalsIgnoreCase(titulo)) {
                return doc;
            }
        }
        return null;
    }

    public ArrayList<Documento> buscarPorAutor(String autor){
        ArrayList<Documento> docs = new ArrayList<>();
        for (Documento doc : documentos){
            for (String aut : doc.getAutores()){
                if (aut.equalsIgnoreCase(autor)){
                    docs.add(doc);
                }
            }
        }
        return docs;
    }

    public Documento buscarPorTipo(String tipo){
        for (Documento doc : documentos) {
            if(doc.getTipoDocumento().equalsIgnoreCase(tipo)) {
                return doc;
            }
        }
        return null;
    }

    public ArrayList<Documento> buscarPorAno(int year){
        ArrayList<Documento> docs = new ArrayList<>();
        for (Documento doc : documentos){
            if (doc.getPublicacion().getValue()==year){
                docs.add(doc);
            }
        }
        return docs;
    }

    public ArrayList<Documento> buscarPorPalabrasClave(String palabra){
        ArrayList<Documento> docs = new ArrayList<>();
        for (Documento doc : documentos){
            for (String aut : doc.getPalabrasClave()){
                if (aut.equalsIgnoreCase(palabra)){
                    docs.add(doc);
                }
            }
        }
        return docs;
    }



    public void accederGestionador(){
        gestionador.gestionar();
    }

    public ArrayList<Documento> todoDocumentos() {
        return documentos;
    }
}
