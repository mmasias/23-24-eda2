package searches;

import java.util.HashMap;
import java.util.Map;

public class Author {
    protected Map<Integer, String> mapAuthors;

    public Author() {
        mapAuthors = new HashMap<>();
    }

    public void addNewAuthor(int id, String nombre) {
        mapAuthors.put(id, nombre);
        System.out.println("Autor agregado: " + nombre);
    }

    public void showAuthorById(int selectId) {
        if (mapAuthors.containsKey(selectId)) {
            String nombreAutor = mapAuthors.get(selectId);
            System.out.println("El autor con ID " + selectId + " es: " + nombreAutor);
        } else {
            System.out.println("No se encontró ningún autor con ID " + selectId);
        }
    }

    public void showAllAuthors() {
        System.out.println("Todos los autores en el mapa:");
        for (Map.Entry<Integer, String> entry : mapAuthors.entrySet()) {
            int idAuthor = entry.getKey();
            String authorName = entry.getValue();
            System.out.println("ID: " + idAuthor + ", Nombre: " + authorName);
        }
    }


}