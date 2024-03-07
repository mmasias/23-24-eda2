import java.util.List;

public class Book extends Document {

    public Book(String titulo, List<Author> autores, int añoPublicacion, List<String> palabrasClave) {
        super(titulo, autores, añoPublicacion, "Libro", palabrasClave);
    }
}
