package entregas.garciaLydia.parcial;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private int id;
    private String title;
    private int publicationYear;
    private final String type;
    private List<BookAuthor> booksAuthors;

    public Book(int id, String title, int publicationYear, String type) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.type = type;
        this.booksAuthors = new ArrayList<>();
    }

    public void addBookAuthor(BookAuthor bookAuthor) {
        booksAuthors.add(bookAuthor);
    }

    public List<BookAuthor> getBooksAuthors() {
        return booksAuthors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", type='" + type + '\'' +
                ", booksAuthors=" + booksAuthors +
                '}';
    }
}
