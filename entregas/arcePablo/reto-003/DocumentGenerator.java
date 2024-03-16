import java.sql.Date;
import java.util.ArrayList;
import java.util.Random;

import Types.DocType;
import Types.KeyWordTypes;

public class DocumentGenerator {
    static Random random = new Random();

    public Document generateRandomDocument() {
        Document document = new Document();

        // Generar título aleatorio
        String[] titles = {"El arte de programar en Java", "Historia del mundo", "Introducción a la inteligencia artificial"};
        document.setTitle(titles[random.nextInt(titles.length)]);

        // Generar autor aleatorio
        String[] authors = {"John Doe", "Jane Smith", "Alice Johnson"};
        document.setAuthor(authors[random.nextInt(authors.length)]);

        // Generar palabras clave aleatorias
        ArrayList<KeyWordTypes> keyWords = new ArrayList<>();
        int numTypes = DocType.values().length;
        int numKeywords = random.nextInt(numTypes); 
        for (int i = 0; i < numKeywords; i++) {
            KeyWordTypes keyword = KeyWordTypes.values()[random.nextInt(KeyWordTypes.values().length)];
            keyWords.add(keyword);
        }
        document.setKeyWords(keyWords);

        // Generar fecha de publicación aleatoria (entre 2000 y 2022)
        long millisSinceEpoch = random.nextLong() % (System.currentTimeMillis() - Date.valueOf("2000-01-01").getTime());
        Date date = new Date(millisSinceEpoch);
        document.setDatePublished(date);

        // Generar tipo de documento aleatorio
        DocType[] types = DocType.values();
        document.setType(types[random.nextInt(types.length)]);

        return document;
    }
}
