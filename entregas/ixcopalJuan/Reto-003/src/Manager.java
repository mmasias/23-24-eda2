import java.util.LinkedList;
public class Manager {
    LinkedList<Author> authors = new LinkedList<>();
    LinkedList<DocumentType> documentTypes = new LinkedList<>();
    LinkedList<Document> documents = new LinkedList<>();
    LinkedList<KeyWord> keyWords = new LinkedList<>();

    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public void addAuthor(Author author){
        authors.add(author);
    }

    public void listAuthors() {
        for (Author author : authors) {
            System.out.println("Autor: " + author.getFullName());
        }
    }

    public void addDocumentType(DocumentType documentType){
        documentTypes.add(documentType);
    }

    public void listDocumentTypes() {
        int number = 1;
        for (DocumentType documentType : documentTypes) {
            System.out.println("Tipo " + number + " : " + documentType.getType());
            number++;
        }
    }

    public void addDocument(Document document){
        documents.add(document);
    }

    public void listDocuments() {
        int number = 1;
        for (Document document : documents){
            System.out.println(number + " -" + document.getDocumentData());
            number++;
        }
    }

    public void removeDocumentByTitle(String title) {
        LinkedList<Document> documentsToRemove = new LinkedList<>();
        for (Document document : documents) {
            if (document.getTitle().equalsIgnoreCase(title)) {
                documentsToRemove.add(document);
            }
        }
        if (!documentsToRemove.isEmpty()) {
            documents.removeAll(documentsToRemove);
            System.out.println(ANSI_CYAN + "Documento(s) eliminado(s) correctamente." + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED + "No se encontró ningún documento con el título '" + title + "'." + ANSI_RESET);
        }
    }

    public void addKeyWords(KeyWord keyword) {
        keyWords.add(keyword);
    }


    public void listKeyWord(){
        int number = 1;
        for (KeyWord keyWord : keyWords){
            System.out.println("Tipo " + number + " : " + keyWord.getKeyWord());
            number++;
        }
    }


    public LinkedList<Document> searchByTitle(String title) {
        LinkedList<Document> foundDocuments = new LinkedList<>();
        for (Document document : documents) {
            if (document.getTitle().equalsIgnoreCase(title)) {
                foundDocuments.add(document);
            }
        }
        return foundDocuments;
    }
}
