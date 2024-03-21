import java.util.*;

public class Obra {

    private String titulo;
    private ArrayList<String> autores;
    private int anoPublicacion;
    private ArrayList<String> temas;
    private ArrayList<String> palabrasClave;
    private String tipoObra;

    // Constructor
    public Obra(String titulo, List<String> autores, int anoPublicacion, List<String> temas,
                List<String> palabrasClave, String tipoObra) {
        this.titulo = titulo;
        this.autores = (ArrayList<String>) autores;
        this.anoPublicacion = anoPublicacion;
        this.temas = (ArrayList<String>) temas;
        this.palabrasClave = (ArrayList<String>) palabrasClave;
        this.tipoObra = tipoObra;
    }

    // Métodos getters y setters 
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public void setAnoPublicacion(int anoPublicacion) {
        this.anoPublicacion = anoPublicacion;
    }

    public ArrayList<String> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<String> temas) {
        this.temas = temas;
    }

    public ArrayList<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(ArrayList<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public String getTipoObra() {
        return tipoObra;
    }

    public void setTipoObra(String tipoObra) {
        this.tipoObra = tipoObra;
    }


    // Método toString para representar la obra como cadena de texto 
    public String toString() {
        return "Obra{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + autores +
                ", anoPublicacion=" + anoPublicacion +
                ", temas=" + temas +
                ", palabrasClave=" + palabrasClave +
                ", tipoObra='" + tipoObra + '\'' +
                '}';
    }
}