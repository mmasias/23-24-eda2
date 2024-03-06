package entregas.oteroJorge.reto003;

import java.util.ArrayList;

public class Documento {

    private String titulo;
    private ArrayList<Autor> autores;
    private String añoPublicacion;
    private String tipo;

    public Documento(String titulo, ArrayList<Autor> autores, String añoPublicacion, String tipo) {
        this.titulo = titulo;
        this.autores = autores;
        this.añoPublicacion = añoPublicacion;
        this.tipo = tipo;
    }

    public void addAutor(Autor autor) {
        autores.add(autor);
    }
}
