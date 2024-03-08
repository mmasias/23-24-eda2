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

    // Getters and setters
    public ArrayList<KeyWordTypes> getKeyWordsInput() {
        return keyWordsInput;
    }

    public void setKeyWordsInput(ArrayList<KeyWordTypes> keyWordsInput) {
        this.keyWordsInput = keyWordsInput;
    }

    public String getTitleInput() {
        return titleInput;
    }

    public void setTitleInput(String titleInput) {
        this.titleInput = titleInput;
    }

    public Date getDateInput() {
        return dateInput;
    }

    public void setDateInput(Date dateInput) {
        this.dateInput = dateInput;
    }

    public String getAuthorInput() {
        return authorInput;
    }

    public void setAuthorInput(String authorInput) {
        this.authorInput = authorInput;
    }

    public DocType getDocTypeInput() {
        return docTypeInput;
    }

    public void setDocTypeInput(DocType docTypeInput) {
        this.docTypeInput = docTypeInput;
    }
}
