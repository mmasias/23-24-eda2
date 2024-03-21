import java.util.ArrayList;
import java.util.List;

class Document {
    private String title;
    private int publishingYear;
    private String type;
    private List<String> keyWords;

    public Document(String title, int publishingYear, String type) {
        this.title = title;
        this.publishingYear = publishingYear;
        this.type = type;
        this.keyWords = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
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

    public void addKeyword(String keyword) {
        if (!keyWords.contains(keyword)) {
            keyWords.add(keyword);
        }
    }

}