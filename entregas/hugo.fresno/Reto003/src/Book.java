import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private int publicationYear;
    private String type;
    private List<Author> authors = new ArrayList<>();

    public Book(int id, String title, int publicationYear, String type) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void addAuthor(Author author) {
        authors.add(author);
        author.addBook(this);
    }

    public List<Author> getAuthors() {
        return authors;
    }

    @Override
    public String toString() {
        StringBuilder authorsList = new StringBuilder("Autores: ");
        if (authors.isEmpty()) {
            authorsList.append("Ninguno");
        } else {
            for (int i = 0; i < authors.size(); i++) {
                authorsList.append(authors.get(i).getName());
                if (i < authors.size() - 1) {
                    authorsList.append(", ");
                }
            }
        }

        return "Libro: \"" + title + "\"\n\tID: " + id + "\n\tAño de Publicación: " + publicationYear + "\n\tTipo: " + type + "\n\t" + authorsList.toString();
    }

}