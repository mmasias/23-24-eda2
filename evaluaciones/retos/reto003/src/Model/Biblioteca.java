package Model;
import java.util.ArrayList;
import java.util.Scanner;

import Factory.*;

public class Biblioteca {
    private ArrayList<Document> documents = new ArrayList<>();
    DocumentoController docController;
    Scanner userInput = new Scanner(System.in);

    public Biblioteca(ArrayList<Document> documents) {
        this.documents = documents;
    }

    public Document searchDocumentByName(String nombreDocumento) {
        for(Document d : documents) {
            if(d.equals(nombreDocumento)){
                return d;
            }
        }
        return null;
    }

    public Document searchDocumentByPublicationYear(int year) {
        for(Document d : documents) {
            if (d.getPublicationYear() == year) {
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

    public void editDocumentPublicationYear(int oldYear, int newYear) {
        Document document = searchDocumentByPublicationYear(oldYear);
        document.setPublicatioYear(newYear);
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

    @Override
    public String toString() {
        StringBuilder documentListing = new StringBuilder();
        for (Document d : documents) {
            documentListing.append(d.toString()).append("\n");
        }
        return documentListing.toString();
    }





}
