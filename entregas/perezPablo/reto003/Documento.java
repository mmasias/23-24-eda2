package reto003;

import java.util.ArrayList;




public class Documento {
    public String titulo;
    public ArrayList<Autor> autores;
    public int anoPublicacion;
    public String tipo;
    public ArrayList<String> palabrasClave;


    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String t) {
        titulo = t;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }
    public void setAutores(ArrayList<Autor> a) {
        autores = a;
    }

    public int getAnio() {
        return anoPublicacion;
    }
    public void setAnio(int a) {
        anoPublicacion = a;
    }

    public String getTipo() {
        return tipo;
    }
    public void setTipo(String t) {
        
    }

    public Documento(String titulo, ArrayList<Autor> autores, int anoPublicacion, String tipo) {
        this.titulo = titulo;
        this.autores = autores;
        this.anoPublicacion = anoPublicacion;
        this.tipo = tipo;
    }

    public String getAutorestoString() {
        StringBuilder sb = new StringBuilder();
        for (Autor a : autores) {
            sb.append(a.getNombre());
            sb.append(" - ");
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return "> " + this.tipo + "\n" + " -> " + this.titulo + "\n" + " -> Autores: " + getAutorestoString()+ "\n" + " -> " + this.anoPublicacion;
    }





}
