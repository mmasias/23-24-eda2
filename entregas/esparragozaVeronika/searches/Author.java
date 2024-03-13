package searches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Author {
    public Map<Integer, String> mapAuthors;
    public Author() {
        mapAuthors = new HashMap<>();
    }
    public void addNewAuthor(int id, String nombre) {
        mapAuthors.put(id, nombre);
        System.out.println("Autor agregado: " + nombre + " con ID: " + id);
    }
    public void addAuthor(String nombre) {
        int id = mapAuthors.size() + 1;
        mapAuthors.put(id, nombre);
        System.out.println(">> Autor agregado: " + nombre + " con ID: " + id);
    }
    public void showAuthorById(int selectId) {
        if (mapAuthors.containsKey(selectId)) {
            String nombreAutor = mapAuthors.get(selectId);
            System.out.println("El autor con ID " + selectId + " es: " + nombreAutor);
        } else {
            System.out.println("No se encontró ningún autor con ID " + selectId);
        }
    }
    public int showAuthorByName(String nombre) {
        for (Map.Entry<Integer, String> entry : mapAuthors.entrySet()) {
            int idAuthor = entry.getKey();
            String authorName = entry.getValue();
            if (authorName.equalsIgnoreCase(nombre)) {
                return idAuthor;
            }
        }
        return -1;
    }
    public void showAllAuthors() {
        System.out.println("Todos los autores en el mapa:");
        for (Map.Entry<Integer, String> entry : mapAuthors.entrySet()) {
            int idAuthor = entry.getKey();
            String authorName = entry.getValue();
            System.out.println("ID: " + idAuthor + ", Nombre: " + authorName);
        }
    }
    public ArrayList<String> printAuthors(ArrayList<Integer> authorsId) {
        ArrayList<String> authorNames = new ArrayList<>();
        for (Integer id : authorsId) {
            if (mapAuthors.containsKey(id)) {
                authorNames.add(mapAuthors.get(id));
            }
        }
    return authorNames;
    }
}