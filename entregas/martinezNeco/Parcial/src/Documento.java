package src;

public class Documento {
    private int id;
    private String titulo;
    private int anio;

    public Documento(int id, String titulo, int anio) {
        this.id = id;
        this.titulo = titulo;
        this.anio = anio;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public int getAnio() { return anio; }

    @Override
    public String toString() {
        return "ID: " + id + ", Titulo: " + titulo + ", Año: " + anio;
    }


}

