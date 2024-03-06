import java.util.ArrayList;
public class Document {
    private String title;
    private ArrayList<String> authors = new ArrayList<>();
    private String yearOfPublication;
    private TypeDocument type;
    private ArrayList<String> keywords = new ArrayList<>();

    public Document(String title, ArrayList<String> authors, String yearOfPublication, TypeDocument type, ArrayList<String> keywords){
        this.title = title;
        this.authors = authors;
        this.yearOfPublication = yearOfPublication;
        this.type = type;
        this.keywords = keywords;
    }
}
