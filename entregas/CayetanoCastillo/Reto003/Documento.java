import java.util.List;

public abstract class Documento {
    protected String titulo;
    protected List<String> autores;
    protected int fechaPublicacion;
    protected String tipo;
    protected List<String> palabrasClave;

    public Documento(String titulo, List<String> autores, int anoPublicacion, String tipo, List<String> palabrasClave) {
        this.titulo = titulo;
        this.autores = autores;
        this.fechaPublicacion = fechaPublicacion;
        this.tipo = tipo;
        this.palabrasClave = palabrasClave;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(int fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
