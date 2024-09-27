package clases;

import java.util.ArrayList;

public  class Documento {
    private String titulo;
    private int añoDePublicacion;
    private ArrayList<Autor> autores;
    private Tipo tipo;
    private ArrayList<String> palabrasClave;

    public Documento(String titulo, int anoDePublicacion, ArrayList<Autor> autores, Tipo tipo ) {
        this.titulo = titulo;
        this.añoDePublicacion = anoDePublicacion;
        this.autores = autores;
        this.tipo = tipo;
        this.palabrasClave = new ArrayList<String>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnoDePublicacion() {
        return añoDePublicacion;
    }

    public void setAnoDePublicacion(int anoDePublicacion) {
        this.añoDePublicacion = anoDePublicacion;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(ArrayList<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public void añadirAutor(Autor autor){
        this.autores.add(autor);
    }

    public  void añadirPalabraClave(String palabraClave){
        this.palabrasClave.add(palabraClave);
    }

    public void eliminarAutor(Autor autor){
        this.autores.remove(autor);
    }

    public void eliminarPalabraClave(String palabraClave){
        this.palabrasClave.remove(palabraClave);
    }

}