import java.sql.Date;
import java.util.ArrayList;

import Types.DocType;
import Types.KeyWordTypes;

public class Searchbar {
    private ArrayList<KeyWordTypes> searchedKeyWords;
    private String searchedTitle;
    private Date searchedDate;
    private String searchedAuthor;
    private DocType searchedDocType;

    public Searchbar() {
        this.searchedKeyWords = new ArrayList<>();
        this.searchedTitle = "";
        this.searchedDate = null;
        this.searchedAuthor = "";
        this.searchedDocType = null;
    }

    public void addKeyword(KeyWordTypes keyword) {
        searchedKeyWords.add(keyword);
    }

    public void removeKeyword(KeyWordTypes keyword) {
        searchedKeyWords.remove(keyword);
    }

    public ArrayList<Document> filterDocuments(ArrayList<Document> documents) {
        ArrayList<Document> filteredDocuments = new ArrayList<>();

        for (Document document : documents) {
            if (containsAnyKeyword(document.getKeyWords()) &&
                (searchedTitle.isEmpty() || document.getTitle().equals(searchedTitle)) &&
                (searchedDate == null || document.getDatePublished().equals(searchedDate)) &&
                (searchedAuthor.isEmpty() || document.getAuthor().equals(searchedAuthor)) &&
                (searchedDocType == null || document.getType().equals(searchedDocType))) {
                filteredDocuments.add(document);
            }
        }

        return filteredDocuments;
    }

    private boolean containsAnyKeyword(ArrayList<KeyWordTypes> documentKeywords) {
        for (KeyWordTypes keyword : searchedKeyWords) {
            if (documentKeywords.contains(keyword)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
    return searchedKeyWords.isEmpty() &&
           searchedTitle.isEmpty() &&
           searchedDate == null &&
           searchedAuthor.isEmpty() &&
           searchedDocType == null;
    }

    // Getters and setters
    public ArrayList<KeyWordTypes> getSearchedKeyWords() {
        return searchedKeyWords;
    }

    public void setSearchedKeyWords(ArrayList<KeyWordTypes> searchedKeyWords) {
        this.searchedKeyWords = searchedKeyWords;
    }

    public String getSearchedTitle() {
        return searchedTitle;
    }

    public void setSearchedTitle(String searchedTitle) {
        this.searchedTitle = searchedTitle;
    }

    public Date getSearchedDate() {
        return searchedDate;
    }

    public void setSearchedDate(Date searchedDate) {
        this.searchedDate = searchedDate;
    }

    public String getSearchedAuthor() {
        return searchedAuthor;
    }

    public void setSearchedAuthor(String searchedAuthor) {
        this.searchedAuthor = searchedAuthor;
    }

    public DocType getSearchedDocType() {
        return searchedDocType;
    }

    public void setSearchedDocType(DocType searchedDocType) {
        this.searchedDocType = searchedDocType;
    }
}
