import java.util.Objects;
import java.util.logging.Logger;

class Book extends LibraryStock {
    Logger logger = Logger.getLogger(Book.class.getName());

    private String author;
    private String genre;

    public Book(String title, String id, String author, String genre) {
        super(title, id);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        logger.info(toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id) ;
    }

    @Override
    public String toString() {
        return "Book{ID='" + id + "', Title='" + title + "', Author='" + author + "', Genre='" + genre + "'}";
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
