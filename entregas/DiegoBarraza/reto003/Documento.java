package entregas.DiegoBarraza.reto003;


import java.util.List;

public class Documento {
    public String titulo;
    public List<String> autores;
    public int añoPublicacion;
    public String tipoDocumento;
    public List<String> palabrasClave;

    public Documento(String titulo, List<String> autores, int añoPublicacion, String tipoDocumento, List<String> palabrasClave) {
        this.titulo = titulo;
        this.autores = autores;
        this.añoPublicacion = añoPublicacion;
        this.tipoDocumento = tipoDocumento;
        this.palabrasClave = palabrasClave;
    }

    public String getTitulo() {
        return titulo;
    }

    public List<String> getAutores() {
        return autores;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public List<String> getPalabrasClave() {
        return palabrasClave;
    }
}