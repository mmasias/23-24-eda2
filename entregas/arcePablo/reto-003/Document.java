import java.sql.Date;
import java.util.ArrayList;

public class Document {
    
    private String title;
    private String author;
    private ArrayList<String> keyWorks;
    private Date datePublished;
    private Enum<DocType> type;
}
