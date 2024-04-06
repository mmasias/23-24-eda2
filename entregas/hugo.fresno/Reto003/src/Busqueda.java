import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;

class Busqueda {
    private List<Libro> libros;

    public Busqueda(List<Libro> libros) {
        this.libros = new ArrayList<>(libros);
    }

    public List<Libro> buscarPorAutor(String autor) {
        List<Libro> resultado = new ArrayList<>();
        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);
            for (int j = 0; j < libro.getAutores().size(); j++) {
                if (libro.getAutores().get(j).equalsIgnoreCase(autor)) {
                    resultado.add(libro);
                    break; // Sal del bucle interno si se encuentra el autor
                }
            }
        }
        return resultado;
    }


    public List<Libro> buscarPorAño(int anio) {
        List<Libro> resultado = new ArrayList<>();
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getAñoPublicacion() == anio) {
                resultado.add(libros.get(i));
            }
        }
        return resultado;
    }

    public List<Libro> buscarPorPalabraClave(String palabraClave) {
        List<Libro> resultado = new ArrayList<>();
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getPalabrasClave().contains(palabraClave)) {
                resultado.add(libros.get(i));
            }
        }
        return resultado;
    }

    public List<Libro> buscarPorTipo(TipoLibro tipo) {
        List<Libro> resultado = new ArrayList<>();
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getTipoLibro() == tipo) {
                resultado.add(libros.get(i));
            }
        }
        return resultado;
    }

}

