package reto003.v01;
import java.util.ArrayList;

public class Documento {
    private String titulo;
    private ArrayList<Autor> autores; 
    private int añoPublicacion;
    private ArrayList<String> palabrasClave;
    private String tipoDocumento;

    public Documento(String titulo, int añoPublicacion, String tipoDocumento) {
        this.titulo = titulo;
        this.autores = new ArrayList<>(); 
        this.añoPublicacion = añoPublicacion;
        this.palabrasClave = new ArrayList<>();
        this.tipoDocumento = tipoDocumento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public ArrayList<Autor> getAutores() { 
        return autores;
    }

    public void addAutor(Autor autor) { 
        autores.add(autor);
    }

    public ArrayList<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void addPalabraClave(String palabraClave) {
        palabrasClave.add(palabraClave.toLowerCase());
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    @Override
    public String toString() {
        return "Documento{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + autoresToString() +
                ", añoPublicacion=" + añoPublicacion +
                ", palabrasClave=" + palabrasClave +
                ", tipoDocumento='" + tipoDocumento + '\'' +
                '}';
    }

    private String autoresToString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < autores.size(); i++) {
            sb.append(autores.get(i).getNombre());
            if (i < autores.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

  
    public static class Autor {
        private String nombre;

        public Autor(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }
    }

    public static class Libro extends Documento {
        public Libro(String titulo, int añoPublicacion) {
            super(titulo, añoPublicacion, "Libro");
        }
    }

    public static class Revista extends Documento {
        public Revista(String titulo, int añoPublicacion) {
            super(titulo, añoPublicacion, "Revista");
        }
    }

    public static class Articulo extends Documento {
        public Articulo(String titulo, int añoPublicacion) {
            super(titulo, añoPublicacion, "Articulo");
        }
    }

    public static class Paper extends Documento {
        public Paper(String titulo, int añoPublicacion) {
            super(titulo, añoPublicacion, "Paper");
        }
    }
}
