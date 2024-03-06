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

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public String getAñoPublicacion() {
        return añoPublicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    private String getAutoresAsString() {
        StringBuilder sb = new StringBuilder();
        for (Autor autor : autores) {
            sb.append(autor.getNombreCompleto());
            sb.append(" -");
        }
        return sb.toString();
    }

    public void printDocumento() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "> " + this.tipo + " -> " + this.titulo + " -> " + getAutoresAsString() + "> " + this.añoPublicacion;
    }

    public static void main(String[] args) {
        ArrayList<Autor> autores = new ArrayList<>();
        autores.add(new Autor("Melendi Oficial"));
        autores.add(new Autor("Antonio Orozco"));

        Documento libro = new Documento("La Voz de tu Corazón", autores, "2020", "Libro");

        libro.printDocumento();
    }

}
