import java.util.*;
import java.time.LocalDate;
import java.util.logging.Logger;

class MemberLib {
    private static final Logger logger = Logger.getLogger(MemberLib.class.getName());

    private String memId;
    private String memName;
    private Set<BorrowedBook> purchasedBooks;

    public MemberLib(String memId, String memName) {
        this.memId = memId;
        this.memName = memName;
        this.purchasedBooks = new HashSet<>();
    }

    public void purchaseBook(String bookId, Set<Book> bookSet) throws BookNotAvailableExcep {
        Book foundBook=null;

        for (Book book : bookSet) {
            if (book.getId().equalsIgnoreCase(bookId)) {
                foundBook = book;
                break;
            }
        }
        if (foundBook == null) {
            throw new BookNotAvailableExcep("BookId: " + bookId + " does not exist.");
        } else if (!foundBook.isAvailable()) {
            throw new BookNotAvailableExcep("Book \"" + foundBook.getTitle() + "\" is not available.");
        }

        foundBook.setAvailable(true);

        LocalDate issueDate = LocalDate.now();
        LocalDate returnDate = issueDate.plusDays(14);

        purchasedBooks.add(new BorrowedBook(foundBook, issueDate, returnDate));
        logger.info(memName + " purchased book: " + foundBook.getTitle());
    }

    public void displayPurchasedBook() {
        logger.info(memName + "'s Purchased Books:");
        if (purchasedBooks.isEmpty()) {
            logger.info("No books purchased yet.");
        } else {
            for (BorrowedBook borrowed : purchasedBooks) {
                borrowed.displayBorrowedBook();
            }
        }
    }

    public boolean hasPurchasedBook(String bookId) {
        for (BorrowedBook borrowed : purchasedBooks) {
            Book book = borrowed.getBook();
            if (book != null && book.getId().equals(bookId)) {
                return true;
            }
        }
        return false;
    }
}
