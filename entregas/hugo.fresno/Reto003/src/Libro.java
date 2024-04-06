import java.util.List;

public class Libro {
    private String titulo;
    private List<String> autores;
    private int añoPublicacion;
    private TipoLibro tipoLibro;
    private List<String> palabrasClave;

    public Libro(String titulo, List<String> autores, int añoPublicacion, TipoLibro tipoLibro, List<String> palabrasClave) {
        this.titulo = titulo;
        this.autores = autores;
        this.añoPublicacion = añoPublicacion;
        this.tipoLibro = tipoLibro;
        this.palabrasClave = palabrasClave;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<String> getAutores() {
        return autores;
    }

    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public TipoLibro getTipoLibro() {
        return tipoLibro;
    }

    public void setTipoLibro(TipoLibro tipoLibro) {
        this.tipoLibro = tipoLibro;
    }

    public List<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(List<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }
}