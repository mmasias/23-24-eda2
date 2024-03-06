import java.util.ArrayList;

public abstract class Documento {
    private String titulo;
    private ArrayList<Autor> autores =  new ArrayList<>();
    private int anhoPublicacion;
    private String tipoDocumento;
    private ArrayList<String> palabrasClave = new ArrayList<>();

    public Documento(String titulo, ArrayList<Autor> autores, int anhoPublicacion,String tipoDocumento, ArrayList<String> palabrasClave) {
        this.titulo = titulo;
        this.autores = autores;
        this.anhoPublicacion = anhoPublicacion;
        this.palabrasClave = palabrasClave;
    }

    public String getTitulo() {
        return titulo;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public int getAnhoPublicacion() {
        return anhoPublicacion;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipo) {
        tipoDocumento = tipo;
    }

    public ArrayList<String> getPalabrasClave() {
        return palabrasClave;
    }

}
