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
        manager.getGestorAutores().agregarAutor(new Autor(1, "J.R.R Tolkien"));
        manager.getGestorAutores().agregarAutor(new Autor(2, "Jorge"));
        manager.getGestorAutores().agregarAutor(new Autor(3, "Luis"));
        manager.getGestorAutores().agregarAutor(new Autor(4, "Juan"));
        manager.getGestorAutores().agregarAutor(new Autor(5, "Pedro"));

        ArrayList<Integer> autores1 = new ArrayList<>();
        autores1.add(1);
        autores1.add(2);

        ArrayList<Integer> autores2 = new ArrayList<>();
        autores2.add(3);
        autores2.add(5);

        ArrayList<Integer> autores3 = new ArrayList<>();
        autores3.add(1);

        Documento libro = new Documento("El señor de los anillos", autores1, "1954", "Libro");
        Documento revista = new Documento("Revista de programación", autores2, "2020", "Revista");
        Documento articulo = new Documento("Articulo de programación", autores3, "2020", "Articulo");

        this.documentos.add(libro);
        this.documentos.add(revista);
        this.documentos.add(articulo);
    }
        
        public static void main(String[] args) {
            Biblioteca biblioteca = new Biblioteca();
        }
}
