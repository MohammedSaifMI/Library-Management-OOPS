import java.time.LocalDate;
import java.util.*;
class MemberLib {
    private String memId;
    private String memName;
    private List<BorrowedBook> purchasedBooks;

    public MemberLib(String  memId, String memName) {
        this.memId = memId;
        this.memName = memName;
        this.purchasedBooks= new ArrayList<>();
    }


    public void purchaseBook(String  bookId, Map<String ,Book>bookHashMap) throws BookNotAvailableExcep {
        Book book = bookHashMap.get(bookId);
        if(book == null) {
            throw new BookNotAvailableExcep("BookId: "+bookId+" Book Not exist");
        } else if (book.isAvailable())
            throw new BookNotAvailableExcep("Book "+book.getTitle()+" Book is not available");{
        }
        book.setAvailable(true);

        LocalDate issueDate = LocalDate.now();
        LocalDate returnDate = issueDate.plusDays(14);

        purchasedBooks.add(new BorrowedBook(book,issueDate,returnDate));
        System.out.println(memName+"'s Purchased book is: "+book.getTitle());
    }
    public void displayPurchasedBook(){
        System.out.println(memName+" Purchased Books are: ");
        for (BorrowedBook borrowed : purchasedBooks) {
            borrowed.displayBorrowedBook();
        }
    }

    public boolean hasPurchasedBook(String bookId){
        for (BorrowedBook borrowed : purchasedBooks) {
            Book book = borrowed.getBook();
            if (book != null && book.getId().equals(bookId)) {
                return true;
            }
        }
        return false;
    }
}
