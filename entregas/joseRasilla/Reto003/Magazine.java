import java.util.List;

public class Magazine extends Document {

    public Magazine(String title, List<Author> authors, int publishingYear, List<String> keyWords) {
        super(title, authors, publishingYear, "Magazine", keyWords);
    }
}
