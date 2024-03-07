package Model;
import java.util.ArrayList;

public class ScientificPaper extends Document {

    public ScientificPaper(String title, ArrayList<Author> authors, int publicationYear, String documentType,
            ArrayList<String> keyWords) {
        super(title, authors, publicationYear, documentType, keyWords);
        
    }

    
    
}
