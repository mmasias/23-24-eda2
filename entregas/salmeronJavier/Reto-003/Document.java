import java.util.ArrayList;
import java.util.List;

class Document {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private int publishingYear;
    private String type;
    private List<String> keyWords = new ArrayList<>();

    public Document(String title, int publishingYear, String type, List<String> keyWords) {
        this.title = title;
        this.publishingYear = publishingYear;
        this.type = type;
        this.keyWords = keyWords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<String> getAuthorNames() {
        List<String> authorNames = new ArrayList<>();
        for (Author author : this.authors) {
            authorNames.add(author.getName());
        }
        return authorNames;
    }    

    public void addAuthor(Author author) {
        if (!authors.contains(author)) {
            authors.add(author);
            author.addDocument(this);
        }
    }

    public void removeAuthor(Author author) {
        if (authors.remove(author)) {
            author.removeDocument(this);
        }
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int newYear) {
        this.publishingYear = newYear;
    }

    public String getType() {
        return type;
    }

    public void setType(String newType) {
        this.type = newType;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = new ArrayList<>(keyWords);
    }

}