package Model;
import java.util.ArrayList;
import java.util.Scanner;


public class Library {
    private ArrayList<Document> documents = new ArrayList<>();
    Scanner userInput = new Scanner(System.in);

    public Library(ArrayList<Document> documents) {
        this.documents = documents;
    }

    public ArrayList<Document> getDocuments() {
        return documents;
    }

    public Document searchDocumentByName(String documentName) {
        for(Document d : documents) {
            if(d.getTitle().equals(documentName)){
                return d;
            }
        }
        return null;
    }

    public Document searchDocumentByPublicationYear(int year) {
        for(Document d : documents) {
            if (d.getPublishingYear() == year) {
                return d;
            }
        }
        return null;
    }


    public void addDocument(Document document) {
       documents.add(document);

    }

    public void editDocumentName(String oldName, String newName) {
        Document document = searchDocumentByName(oldName);
        document.setTitle(newName);

    }

    public void editDocumentAuthor(String title, Author oldAuthor, Author newAuthor) {
        Document document = searchDocumentByName(title);
        int oldAuthorIndex = document.searchAuthorIndex(oldAuthor);
        document.getAuthors().set(oldAuthorIndex, newAuthor);

    }

    public void editDocumentPublishingYear(String title, int oldYear, int newYear) {
        Document document = searchDocumentByName(title);
        document.setPublishingYear(newYear);
    }

    public void editDocumentKeyWord(String title, String oldKeyWord, String newKeyWord) {
        Document document = searchDocumentByName(title);
        int oldWordIndex = document.searchKeyWordIndex(oldKeyWord);
        document.getKeyWords().set(oldWordIndex, newKeyWord);

        
    }

    public void editDocumentType(String title, String oldType, String newType) {
        Document document = searchDocumentByName(title);
        document.setDocumentType(newType);

    }

    public void deleteDocument(String title) {
        Document document = searchDocumentByName(title);
        documents.remove(document);
    }

    public void deleteAllDocuments() {
        documents.clear();
    }

    
    public String toStringDocuments() {
        StringBuilder documentListing = new StringBuilder();
        for (Document d : documents) {
            documentListing.append(d.toStringDocument()).append("\n");
        }
        return documentListing.toString();
    }





}
