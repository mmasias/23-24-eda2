import java.util.LinkedList;
public class Library {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Author autor1 = new Author("Juan Perez");
        Author autor2 = new Author("Manolo Martinez");

        DocumentType tipo1 = new DocumentType("Libro");
        DocumentType tipo2 = new DocumentType("Revista");
        DocumentType tipo3 = new DocumentType("Articulo");
        DocumentType tipo4 = new DocumentType("Paper Cientifico");

        KeyWord keyWord1 = new KeyWord("Ciencia");
        KeyWord keyWord2 = new KeyWord("Fantasia");
        KeyWord keyWord3 = new KeyWord("Aventura");
        KeyWord keyWord4 = new KeyWord("Naturaleza");

        LinkedList<KeyWord> keyWords = new LinkedList<>();
        keyWords.add(keyWord1);
        keyWords.add(keyWord2);
        keyWords.add(keyWord3);
        keyWords.add(keyWord4);

        Document documento1 = new Document("Libro", "Miguel de Cervantes", "Don Quijote", keyWords , 2024);

        manager.addAuthor(autor1);
        manager.addAuthor(autor2);

        manager.addDocumentType(tipo1);
        manager.addDocumentType(tipo2);
        manager.addDocumentType(tipo3);
        manager.addDocumentType(tipo4);

        manager.addDocument(documento1);
        manager.addDocument(documento1);

        for (KeyWord keyword : keyWords) {
            manager.addKeyWords(keyword);
        }

        manager.listAuthors();
        manager.listDocumentTypes();
        manager.listDocuments();

        manager.listKeyWord();
    }
}