import java.util.ArrayList;
import java.util.List;

public class GestionLibro {
    private List<Libro> libros;

    public GestionLibro() {
        this.libros = new ArrayList<>();
    }

    public void agregarLibro(Libro libro) {
        if (libro != null && libro.getTitulo() != null && !libro.getTitulo().trim().isEmpty()) {
            libros.add(libro);
        }
    }

    public boolean eliminarLibro(String titulo) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                libros.remove(i);
                return true;
            }
        }
        return false;
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return libros.get(i);
            }
        }
        return null;
    }

    public void editarLibro(String tituloOriginal, Libro libroModificado) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTitulo().equalsIgnoreCase(tituloOriginal)) {
                libros.set(i, libroModificado);
                return;
            }
        }
    }

    public List<Libro> getLibros() {
        return new ArrayList<>(libros);
    }

    public void mostrarLibros() {
        if (libros.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
            return;
        }

        for (Libro libro : libros) {
            System.out.println("\nTitulo: " + libro.getTitulo());
            System.out.println("Tipo: " + libro.getTipoLibro());
            System.out.println("Autor(es): " + String.join(", ", libro.getAutores()));
            System.out.println("Año de Publicación: " + libro.getAñoPublicacion());
            System.out.println("Palabras Clave: " + String.join(", ", libro.getPalabrasClave()));
            System.out.println("-----------------------------------");
        }
    }

}
