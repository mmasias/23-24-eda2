package src;

import java.util.ArrayList;

public class Documento {
    private String titulo;
    private int anoDePublicacion;
    private ArrayList<Autor> autores;
    private Tipo tipo;
    private ArrayList<String> palabrasClave;

    public Documento(String titulo, int anoDePublicacion, ArrayList<Autor> autores, Tipo tipo) {
        this.titulo = titulo;
        this.anoDePublicacion = anoDePublicacion;
        this.autores = new ArrayList<>(autores);
        this.tipo = tipo;
        this.palabrasClave = new ArrayList<>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoDePublicacion() {
        return anoDePublicacion;
    }

    public void setAnoDePublicacion(int anoDePublicacion) {
        this.anoDePublicacion = anoDePublicacion;
    }

    public ArrayList<Autor> getAutores() {
        return new ArrayList<>(autores);
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = new ArrayList<>(autores);
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getPalabrasClave() {
        return new ArrayList<>(palabrasClave);
    }

    public void setPalabrasClave(ArrayList<String> palabrasClave) {
        this.palabrasClave = new ArrayList<>(palabrasClave);
    }

    public void añadirAutor(Autor autor) {
        autores.add(autor);
    }

    public void eliminarAutor(Autor autor) {
        autores.remove(autor);
    }

    public void añadirPalabraClave(String palabra) {
        palabrasClave.add(palabra);
    }

    public void eliminarPalabraClave(String palabra) {
        palabrasClave.remove(palabra);
    }
}
