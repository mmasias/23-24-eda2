package searches;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class KeywordManager {
    protected Map<Integer, String> mapKeyword;
    public KeywordManager() {
        mapKeyword = new HashMap<>();
    }
    public void addKeyword(int id, String keyword) {
        mapKeyword.put(id, keyword);
    }
    public void addKeyword(String keyword) {
        int id = mapKeyword.size() + 1;
        mapKeyword.put(id, keyword);
    }
    public int showKeywordByName(String keyword) {
        for (Map.Entry<Integer, String> entry : mapKeyword.entrySet()) {
            int idKeyword = entry.getKey();
            String textKeyword = entry.getValue();
            if (textKeyword.equalsIgnoreCase(keyword)) {
                return idKeyword;
            }
        }
        return -1;
    }
    public void showAllKeywords() {
        System.out.println("Todas las palabras claves en el mapa:");
        for (Map.Entry<Integer, String> entry : mapKeyword.entrySet()) {
            int idKeyword = entry.getKey();
            String textKeyword = entry.getValue();
            System.out.println("ID: " + idKeyword + ", Palabra clave: " + textKeyword);
        }
    }
    public ArrayList<String> printKeywords(ArrayList<Integer> keywordsId) {
        ArrayList<String> keywordValues = new ArrayList<>();
        for (Integer id : keywordsId) {
            if (mapKeyword.containsKey(id)) {
                keywordValues.add(mapKeyword.get(id));
            }
        }
        return keywordValues;
    }
}
