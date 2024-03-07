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

    // Constructor
    public Documento(String titulo, String autor, TipoDocumento tipo) {
        this.titulo = titulo;
        this.autor = autor;
        this.tipo = tipo;
    }

    // Métodos getter
    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public TipoDocumento getTipo() {
        return tipo;
    }

    // Método toString para imprimir información del documento
    @Override
    public String toString() {
        return "Documento{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", tipo=" + tipo +
                '}';
    }
}
