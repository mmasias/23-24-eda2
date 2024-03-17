package searches;

import typeDocument.Document;

import java.util.ArrayList;

public class SearchDocument {
    private final ArrayList<Document> documents;
    private final Author authors;
    private final Keyword keywords;

    public SearchDocument(ArrayList<Document> documents, Author authors, Keyword keywords){
        this.documents = documents;
        this.authors = authors;
        this.keywords = keywords;
    }
    public void newSearch(String typeOfSearch, String dataToSearch){
        switch (typeOfSearch) {
            case "title":
                printResult(searchByTitle(dataToSearch));
                break;
            case "author":
                printResult(searchByAuthor(dataToSearch));
                break;
            case "year":
                printResult(searchByYear(dataToSearch));
                break;
            case "type":
                switch (dataToSearch) {
                    case "1" -> dataToSearch = "Article";
                    case "2" -> dataToSearch = "Magazine";
                    case "3" -> dataToSearch = "Book";
                    case "4" -> dataToSearch = "Paper";
                }
                printResult(searchByType(dataToSearch));
                break;
            case "keyword":
                printResult(searchByKeyword(dataToSearch));
                break;
            default:
                break;
        }
    }
    private ArrayList<Document> searchByTitle(String title){
        ArrayList<Document> result = new ArrayList<>();
        for (Document document : documents) {
            if (document.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(document);
            }
        }
        return result;
    }
    public ArrayList<Document> searchByAuthor(String authorName) {
        ArrayList<Document> result = new ArrayList<>();
        if (authors != null) {
            ArrayList<String> similarAuthors = authors.findSimilarAuthors(authorName);
            for (String similarAuthor : similarAuthors) {
                int authorId = authors.showAuthorByName(similarAuthor);
                if (authorId != -1) {
                    for (Document document : documents) {
                        if (document.getAuthorsId().contains(authorId)) {
                            result.add(document);
                        }
                    }
                }
            }
        }
        return result;
    }
    private ArrayList<Document> searchByYear(String year){
        ArrayList<Document> result = new ArrayList<>();
        for (Document document : documents) {
            if (document.getYearOfPublication() == Integer.parseInt(year)) {
                result.add(document);
            }
        }
        return result;
    }
    private ArrayList<Document> searchByType(String type){
        ArrayList<Document> result = new ArrayList<>();
        for (Document document : documents) {
            if (document.getType().equals(type)) {
                result.add(document);
            }
        }
        return result;
    }
    public ArrayList<Document> searchByKeyword(String keywordName) {
        ArrayList<Document> result = new ArrayList<>();
        if (keywords != null) {
            int keywordId = keywords.showKeywordByName(keywordName);
            if (keywordId != -1) {
                for (Document document : documents) {
                    if (document.getKeywordsId().contains(keywordId)) {
                        result.add(document);
                    }
                }
            }
        }
        return result;
    }
    public void printResult(ArrayList<Document> arrayList) {
        if (arrayList.isEmpty()) {
            System.out.println("No se encontraron resultados");
        } else {
            System.out.println("Resultados de la busqueda: ");
            for (Document object : arrayList) {
                System.out.println("-> " + object.toString(this.authors, this.keywords));
            }
        }
    }
}
