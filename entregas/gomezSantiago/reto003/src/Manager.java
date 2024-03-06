import java.util.LinkedList;

public class Manager {
    LinkedList<Author> authors = new LinkedList<>();
    LinkedList<DocumentType> documentTypes = new LinkedList<>();
    LinkedList<Document> documents = new LinkedList<>();
    LinkedList<String> keyWords = new LinkedList<>();

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
        for (DocumentType documentType : documentTypes) {
            System.out.println("Tipo de documento: " + documentType.getType());
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

    public void addKeyWords(String keyword) {
        keyWords.add(keyword);
    }
}
