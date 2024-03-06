package entregas.oteroJorge.reto003;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<Documento> documentos;
    private Manager manager = new Manager();

    public Biblioteca() {
        this.documentos = new ArrayList<>();
        this.ingresarDocumentos();
        manager.setDocumentos(documentos);
        manager.run();
    }

    public void ingresarDocumentos(){
        ArrayList<Autor> doc1 = new ArrayList<>();
        doc1.add(new Autor("J.R.R. Tolkien"));
        Documento documento1 = new Documento("El señor de los anillos", doc1, "1954", "Libro");
        this.documentos.add(documento1);
        ArrayList<Autor> doc2 = new ArrayList<>();  
        doc2.add(new Autor("J.K. Rowling"));
        Documento documento2 = new Documento("Harry Potter y la piedra filosofal", doc2, "1997", "Libro");
        this.documentos.add(documento2);
        ArrayList<Autor> doc3 = new ArrayList<>();
        doc3.add(new Autor("George R.R. Martin"));
        Documento documento3 = new Documento("Juego de tronos", doc3, "1996", "Libro");
        this.documentos.add(documento3);
        ArrayList<Autor> doc4 = new ArrayList<>();
        doc4.add(new Autor("J.R.R. Tolkien"));
        Documento documento4 = new Documento("El hobbit", doc4, "1937", "Libro");
        this.documentos.add(documento4);
        ArrayList<Autor> doc5 = new ArrayList<>();
        doc5.add(new Autor("Angelina Jolie")); 
        doc5.add(new Autor("Brad Pitt"));
        Documento documento5 = new Documento("El código Da Vinci", doc5, "2003", "Revista");
        this.documentos.add(documento5);
        ArrayList<Autor> doc6 = new ArrayList<>();
    }
        
        public static void main(String[] args) {
            Biblioteca biblioteca = new Biblioteca();
        }
}
