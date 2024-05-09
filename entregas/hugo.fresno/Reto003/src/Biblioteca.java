import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private GestionLibro gestionLibro;
    private Busqueda busqueda;

    public Biblioteca() {
        this.gestionLibro = new GestionLibro();
        this.busqueda = new Busqueda(gestionLibro.getLibros());
    }

    public void agregarLibro(Libro libro) {
        gestionLibro.agregarLibro(libro);
        this.busqueda = new Busqueda(gestionLibro.getLibros());
    }

    public void mostrarLibros() {
        gestionLibro.mostrarLibros();
    }

    public List<Libro> buscarPorAutor(String autor) {
        return busqueda.buscarPorAutor(autor);
    }

    public List<Libro> buscarPorAnio(int anio) {
        return busqueda.buscarPorAño(anio);
    }

    public List<Libro> buscarPorPalabraClave(String palabraClave) {
        return busqueda.buscarPorPalabraClave(palabraClave);
    }

    public List<Libro> buscarPorTipo(TipoLibro tipo) {
        return busqueda.buscarPorTipo(tipo);
    }

    public Libro buscarLibroPorTitulo(String titulo) {

        return gestionLibro.buscarLibroPorTitulo(titulo);
    }

    public void imprimirResultadosBusqueda(List<Libro> resultados) {
        if (resultados.isEmpty()) {
            System.out.println("No se encontraron resultados.");
        } else {
            for (Libro libro : resultados) {
                System.out.println(libro.getTitulo() + " - " + String.join(", ", libro.getAutores()));
            }
        }
    }

}
