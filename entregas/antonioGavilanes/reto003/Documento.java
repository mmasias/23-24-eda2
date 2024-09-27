package antonioGavilanes.reto003;

class Documento {
    private String titulo;
    private String autor;
    private String año;
    private String tipo;
    private String palabrasClave;

    public Documento(String titulo, String autor, String año, String tipo, String palabrasClave) {
        this.titulo = titulo;
        this.autor = autor;
        this.año = año;
        this.tipo = tipo;
        this.palabrasClave = palabrasClave;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getAño() {
        return año;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPalabrasClave() {
        return palabrasClave;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setPalabrasClave(String palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    @Override
    public String toString() {
        return "Documento: " + titulo;
    }
}
