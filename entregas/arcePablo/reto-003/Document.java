import java.sql.Date;
import java.util.ArrayList;

import Types.DocType;
import Types.KeyWordTypes;

public class Document {
    private String title;
    private String author;
    private ArrayList<KeyWordTypes> keyWords;
    private Date datePublished;
    private Enum<DocType> type;

    public Document() {
        title = "";
        author = "";
        keyWords = new ArrayList<>();
        datePublished = new Date(0);
        type = DocType.OTRO;
    }
    
    public Document(String title, String author, ArrayList<KeyWordTypes> keyWords, Date datePublished, Enum<DocType> type) {
        this.title = title;
        this.author = author;
        this.keyWords = keyWords;
        this.datePublished = datePublished;
        this.type = type;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public ArrayList<KeyWordTypes> getKeyWords() {
        return keyWords;
    }
    
    public void setKeyWords(ArrayList<KeyWordTypes> keyWords) {
        this.keyWords = keyWords;
    }
    
    public Date getDatePublished() {
        return datePublished;
    }
    
    public void setDatePublished(Date datePublished) {
        this.datePublished = datePublished;
    }
    
    public Enum<DocType> getType() {
        return type;
    }
    
    public void setType(Enum<DocType> type) {
        this.type = type;
    }
}
