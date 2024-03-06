package entregas.puenteDaniel.Reto003;

import java.util.ArrayList;

public class Documento {
    private String titulo;
    private int año;
    private ArrayList<Autor> autores;
    private ArrayList<String> palabras_clave;
    private Tipo tipo;

    public Documento(String titulo, int año, ArrayList<Autor> autores, Tipo tipo) {
        this.titulo = titulo;
        this.año = año;
        this.autores = autores;
        this.tipo = tipo;
        this.palabras_clave = new ArrayList<String>();
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public void setPalabras_clave(ArrayList<String> palabras_clave) {
        this.palabras_clave = palabras_clave;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getAño() {
        return año;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public ArrayList<String> getPalabras_clave() {
        return palabras_clave;
    }

    public Tipo getTipo() {
        return tipo;
    }
    
    public void añadirAutor(Autor autor){
        autores.add(autor);
    }

    public void añadirPalabraClave(String palabra){
        palabras_clave.add(palabra);
    }

    public void eliminarAutor(Autor autor){
        autores.remove(autor);
    }

    public void eliminarPalabraClave(String palabra){
        palabras_clave.remove(palabra);
    }
}
