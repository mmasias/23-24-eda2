package searches;

import java.util.HashMap;
import java.util.Map;

public class Keyword {
    protected Map<Integer, String> mapKeyword;

    public Keyword() {
        mapKeyword = new HashMap<>();
    }

    public void addNewKeyword(int id, String keyword) {
        mapKeyword.put(id, keyword);
    }

    public void showKeywordById(int selectId) {
        if (mapKeyword.containsKey(selectId)) {
            String textKeyword = mapKeyword.get(selectId);
            System.out.println("La palabra clave con ID " + selectId + " es: " + textKeyword);
        } else {
            System.out.println("No se encontró ninguna palabra clave con ID " + selectId);
        }
    }

    public void showAllKeywords() {
        System.out.println("Todas las palabras claves en el mapa:");
        for (Map.Entry<Integer, String> entry : mapKeyword.entrySet()) {
            int idKeyword = entry.getKey();
            String textKeyword = entry.getValue();
            System.out.println("ID: " + idKeyword + ", Palabra clave: " + textKeyword);
        }
    }
}
