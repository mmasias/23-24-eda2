package entregas.garciaLydia.parcial;

public class BookAuthor {
    private Author author;
    private Book book;

    public BookAuthor(Author author, Book book) {
        this.author = author;
        this.book = book;
    }

    @Override
    public String toString() {
        return author.getName() + " - " + book.toString();
    }
}
