package entregas.oteroJorge.reto003;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Documento> documentos;
    private Manager manager = new Manager();
    public Biblioteca() {
        this.documentos = new ArrayList<>();
        //this.ingresarDocumentos();
        manager.setDocumentos(documentos);
        manager.run();
    }

    public void ingresarDocumentos(){
        manager.getGestorAutores().agregarAutor(new Autor(1, "J.R.R Tolkien"));
        manager.getGestorAutores().agregarAutor(new Autor(2, "Jorge"));
        manager.getGestorAutores().agregarAutor(new Autor(3, "Luis"));
        


    }
        
        public static void main(String[] args) {
            Biblioteca biblioteca = new Biblioteca();
        }
}
