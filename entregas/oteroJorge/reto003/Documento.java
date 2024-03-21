package entregas.oteroJorge.reto003;

import java.util.ArrayList;

public class Documento {

    private String titulo;
    private ArrayList<Integer> idAutores;
    private String añoPublicacion;
    private String tipo;

    public Documento(String titulo, ArrayList<Integer> idAutores, String añoPublicacion, String tipo) {
        this.titulo = titulo;
        this.idAutores = idAutores;
        this.añoPublicacion = añoPublicacion;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(String añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAutores(ArrayList<Integer> idAutores) {
        this.idAutores = idAutores;
    }

    public ArrayList<Integer> getIdAutores() {
        return idAutores;
    }

    public int getIdAutor(int index) {
        return idAutores.get(index);
    }

    public void printDocumento(GestorAutores gestorAutores) {
        System.out.println(this.toString(gestorAutores));
    }

    public String listarAutores(GestorAutores gestorAutores) {
        String autores = "";
        for (int id : this.idAutores) {
            for (Autor autor : gestorAutores.getAutores()) {
                if (autor.getId() == id) {
                    autores += autor.getNombreCompleto() + " -";
                }
            }
        }
        return autores;
    }

    public String toString(GestorAutores gestorAutores) {
        return "> " + this.tipo + " -> " + this.titulo + " -> " + this.listarAutores(gestorAutores) + "> " + this.añoPublicacion;
    }

    public static void main(String[] args) {
        GestorAutores gestorAutores = new GestorAutores();
        Autor autor1 = new Autor(1, "Jorge");
        Autor autor2 = new Autor(2, "Isaac Asimov");
        Autor autor3 = new Autor(3, "J.R.R. Tolkien");
        gestorAutores.agregarAutor(autor1);
        gestorAutores.agregarAutor(autor2);
        gestorAutores.agregarAutor(autor3);
        ArrayList<Integer> autores = new ArrayList<>();
        autores.add(1);
        autores.add(3);
        Documento documento1 = new Documento("El señor de los anillos", autores, "1954",  "Libro");
        documento1.printDocumento(gestorAutores);

    }

}
