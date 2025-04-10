import java.time.LocalDate;
public class BorrowedBook {
    private Book book;
    private LocalDate issueDate;
    private LocalDate returnDate;

    public BorrowedBook(Book book, LocalDate issueDate, LocalDate returnDate) {
        this.book =book;
        this.issueDate =issueDate;
        this.returnDate=returnDate;

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
        System.out.println("Borrowed book is: "+book.getTitle()+" IssueDate: "+
                issueDate+" ReturnDate: "+returnDate);
    }
}
