import java.time.LocalDate;
import java.util.logging.Logger;

public class BorrowedBook {
    private static final Logger logger = Logger.getLogger(BorrowedBook.class.getName());

    private Book book;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public BorrowedBook(Book book, LocalDate issueDate, LocalDate returnDate) {
        this.book = book;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void displayBorrowedBook() {
        logger.info(toString());
    }

    @Override
    public String toString() {
        return "BorrowedBook{" +
                "book=" + book.getTitle() +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
