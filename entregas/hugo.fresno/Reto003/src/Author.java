import java.util.ArrayList;
import java.util.List;

public class Author {
    private int id;
    private String name;
    private List<Book> books = new ArrayList<>();

    public Author(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addBook(Book book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }
    @Override
    public String toString() {
        return String.format("Autor: '%s' (ID: %d)", name, id);
    }

}