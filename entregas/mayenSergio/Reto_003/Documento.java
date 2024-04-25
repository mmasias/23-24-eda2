package entregas.mayenSergio.Reto_003;

public class Documento {
    
    public enum TipoDocumento {
        LIBRO,
        REVISTA,
        ARTICULO,
        PAPER
    }

    private String titulo;
    private String autor;
    private TipoDocumento tipo;

    public Documento(String titulo, String autor, TipoDocumento tipo) {
        this.titulo = titulo;
        this.autor = autor;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setAutor(String autor){
        this.autor = autor;
    }

    public void setTipo(TipoDocumento tipo){
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
