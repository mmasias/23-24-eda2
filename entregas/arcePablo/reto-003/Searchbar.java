import java.sql.Date;
import java.util.ArrayList;

import Types.DocType;
import Types.KeyWordTypes;

public class Searchbar {
    private ArrayList<KeyWordTypes> keyWordsInput;
    private String titleInput;
    private Date dateInput;
    private String authorInput;
    private DocType docTypeInput;

    public Searchbar() {
        this.keyWordsInput = new ArrayList<>();
        this.titleInput = "";
        this.dateInput = null;
        this.authorInput = "";
        this.docTypeInput = null;
    }

    public void addKeyword(KeyWordTypes keyword) {
        keyWordsInput.add(keyword);
    }

    public void removeKeyword(KeyWordTypes keyword) {
        keyWordsInput.remove(keyword);
    }

    public ArrayList<Document> filterDocuments(ArrayList<Document> documents) {
        ArrayList<Document> filteredDocuments = new ArrayList<>();

        for (Document document : documents) {
            if (containsAnyKeyword(document.getKeyWords()) &&
                (titleInput.isEmpty() || document.getTitle().equals(titleInput)) &&
                (dateInput == null || document.getDatePublished().equals(dateInput)) &&
                (authorInput.isEmpty() || document.getAuthor().equals(authorInput)) &&
                (docTypeInput == null || document.getType().equals(docTypeInput))) {
                filteredDocuments.add(document);
            }
        }

        if (filteredDocuments.isEmpty()) {
            return documents;
        } else {
            return filteredDocuments;
        }
    }

    private boolean containsAnyKeyword(ArrayList<KeyWordTypes> documentKeywords) {
        for (KeyWordTypes keyword : keyWordsInput) {
            if (documentKeywords.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    public void displayInputs() {
        System.out.println("\nBuscador: ");

        if (!titleInput.isEmpty() && titleInput != null) {
            System.out.println("Título: " + titleInput);
        }

        if (!keyWordsInput.isEmpty() && keyWordsInput != null) {
            System.out.print("Palabras claves: ");
            for (KeyWordTypes keyword : keyWordsInput) {
                System.out.print(keyword + ", ");
            }
            System.out.println();
        }

        if (dateInput != null) {
            System.out.println("Fecha: " + dateInput);
        }

        if (!authorInput.isEmpty() && authorInput != null) {
            System.out.println("Autor: " + authorInput);
        }

        if (docTypeInput != null) {
            System.out.println("Tipo de documento: " + docTypeInput);
        }
                
        System.out.println("");
    }
}
