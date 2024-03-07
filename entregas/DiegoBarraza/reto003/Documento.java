package entregas.DiegoBarraza.reto003;


import java.util.List;

abstract class Documento {
    protected String titulo;
    protected List<String> autores;
    protected int añoPublicacion;
    protected String tipoDocumento;
    protected List<String> palabrasClave;

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