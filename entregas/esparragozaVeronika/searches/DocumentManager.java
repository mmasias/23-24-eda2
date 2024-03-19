package searches;

import typeDocument.Article;
import typeDocument.Document;

import java.util.ArrayList;
import java.util.Scanner;

public class DocumentManager {
    Scanner input = new Scanner(System.in);
    private final ArrayList<Document> documents;
    private final AuthorManager authors;
    private final KeywordManager keywords;

    public DocumentManager(ArrayList<Document> documents, AuthorManager authors, KeywordManager keywords){
        this.documents = documents;
        this.authors = authors;
        this.keywords = keywords;
    }

    public void add(Document document){
        documents.add(document);
    }
    public ArrayList<Document> searchByTitle(String title){
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
    public ArrayList<Document> searchByYearOfPublication(int year){
        ArrayList<Document> result = new ArrayList<>();
        for (Document document : documents) {
            if (document.getYearOfPublication() == (year)) {
                result.add(document);
            }
        }
        return result;
    }
    public ArrayList<Document> searchByType(String type){
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
            ArrayList<String> similarKeyword = keywords.findSimilarKeyWords(keywordName);
            for (String keyword : similarKeyword) {
                int keywordId = keywords.showKeywordByName(keyword);
                if (keywordId != -1) {
                    for (Document document : documents) {
                        if (document.getKeywordsId().contains(keywordId)) {
                            result.add(document);
                        }
                    }
                }
            }
        }
        return result;
    }

    public ArrayList<Document> getAllDocuments() {
        return documents;
    }
}
