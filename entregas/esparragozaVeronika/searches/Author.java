package searches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Author {
    public Map<Integer, String> mapAuthors;
    public Author() {
        mapAuthors = new HashMap<>();
    }
    public void addNewAuthor(int id, String name) {
        mapAuthors.put(id, name);
        System.out.println("Autor agregado: " + name + " con ID: " + id);
    }
    public void addAuthor(String name) {
        int id = mapAuthors.size() + 1;
        mapAuthors.put(id, name);
        System.out.println(">> Autor agregado: " + name + " con ID: " + id);
    }
    public int showAuthorByName(String name) {
        for (Map.Entry<Integer, String> entry : mapAuthors.entrySet()) {
            int idAuthor = entry.getKey();
            String authorName = entry.getValue();
            if (authorName.equalsIgnoreCase(name)) {
                return idAuthor;
            }
        }
        return -1;
    }
    public void showAllAuthors() {
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
    public ArrayList<String> findSimilarAuthors(String authorName) {
        ArrayList<String> similarAuthors = new ArrayList<>();
        ArrayList<String> authorNames = new ArrayList<>(mapAuthors.values());
            for (String name : authorNames) {
                if (name.toLowerCase().contains(authorName.toLowerCase())) {
                    similarAuthors.add(name);
                }
            }
        return similarAuthors;
    }
}