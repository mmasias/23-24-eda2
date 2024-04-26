package entregas.garciaLydia.reto003;

import java.util.List;

public class Documento {
    private String titulo;
    private List<String> autores;
    private int anoPublicacion;
    private String tipoDocumento;
    private List<String> palabrasClave;


    public Documento(String titulo, List<String> autores, int anoPublicacion, String tipoDocumento, List<String> palabrasClave) {
        this.titulo = titulo;
        this.autores = autores;
        this.anoPublicacion = anoPublicacion;
        this.tipoDocumento = tipoDocumento;
        this.palabrasClave = palabrasClave;
    }


    public String getTitulo() {
        return titulo;
    }

    public List<String> getAutores() {
        return autores;
    }

    public int getAnoPublicacion() {
        return anoPublicacion;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public List<String> getPalabrasClave() {
        return palabrasClave;
    }
}
