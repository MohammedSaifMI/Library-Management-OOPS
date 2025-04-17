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

    public void purchaseBook(String bookId, Map<String, Book> bookHashMap) throws BookNotAvailableExcep {
        Book book = bookHashMap.get(bookId);

        if (book == null) {
            throw new BookNotAvailableExcep("BookId: " + bookId + " does not exist.");
        } else if (book.isAvailable()) {
            throw new BookNotAvailableExcep("Book \"" + book.getTitle() + "\" is not available.");
        }

        book.setAvailable(false);

        LocalDate issueDate = LocalDate.now();
        LocalDate returnDate = issueDate.plusDays(14);

        purchasedBooks.add(new BorrowedBook(book, issueDate, returnDate));
        logger.info(memName + " purchased book: " + book.getTitle());
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
