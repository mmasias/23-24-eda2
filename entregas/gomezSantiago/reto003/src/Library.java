import java.util.LinkedList;

public class Library {
    public static void main(String[] args) {
        Manager manager = new Manager();

        LinkedList<String> keyWords = new LinkedList<>();

        Author autor1 = new Author("Juan Perez");
        Author autor2 = new Author("Manolo Martinez");

        DocumentType tipo1 = new DocumentType("Libro");
        DocumentType tipo2 = new DocumentType("Revista");
        DocumentType tipo3 = new DocumentType("Articulo");
        DocumentType tipo4 = new DocumentType("Paper Cientifico");

        keyWords.add("Ciencia");
        keyWords.add("Fantasia");
        keyWords.add("Aventura");
        keyWords.add("Naturaleza");


        Document documento1 = new Document("Libro", "Miguel de Cervantes", "Don Quijote", keyWords, 2024);

        manager.addAuthor(autor1);
        manager.addAuthor(autor2);

        manager.addDocumentType(tipo1);
        manager.addDocumentType(tipo2);
        manager.addDocumentType(tipo3);
        manager.addDocumentType(tipo4);

        manager.addDocument(documento1);
        manager.addDocument(documento1);

        manager.listAuthors();
        manager.listDocumentTypes();
        manager.listDocuments();
    }
}