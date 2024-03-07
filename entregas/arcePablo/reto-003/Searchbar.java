import java.sql.Date;
import java.util.ArrayList;

import Types.DocType;
import Types.KeyWordTypes;

public class Searchbar {
    private ArrayList<KeyWordTypes> keyWordsInput;
    private String titleInput;
    private Date dateInput;
    private String authorInput;
    private DocType docType;

    public Searchbar() {
        this.keyWordsInput = new ArrayList<>();
        this.titleInput = "";
        this.dateInput = null;
        this.authorInput = "";
        this.docType = null;
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
                (docType == null || document.getType().equals(docType))) {
                filteredDocuments.add(document);
            }
        }

        return filteredDocuments;
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
        System.out.println("Buscador: ");

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

        if (docType != null) {
            System.out.println("Tipo de documento: " + docType);
        }
    }
}
