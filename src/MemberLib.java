import java.util.*;
class MemberLib {
    private String memId;
    private String memName;
    private List<Book> purchasedBook;

    public MemberLib(String  memId, String memName) {
        this.memId = memId;
        this.memName = memName;
        this.purchasedBook= new ArrayList<>();
    }


    public void purchaseBook(String  bookId, HashMap<String ,Book>bookHashMap) throws BookNotAvailableExcep {
        Book book = bookHashMap.get(bookId);
        if(book == null) {
            throw new BookNotAvailableExcep("BookId: "+bookId+" Book Not exist");
        } else if (!book.isAvailable())
            throw new BookNotAvailableExcep("Book "+book.getTitle()+" Book is not available");{
        }
        book.setAvailable(false);
        purchasedBook.add(book);
        System.out.println(memName+"'s Purchased book is: "+book.getTitle());
    }

    public void displayPurchasedBook(){
        System.out.println(memName+" Purchased Books are: ");
        for (int i = 0; i < purchasedBook.size(); i++) {
            Book book = purchasedBook.get(i);
            System.out.println(book.getTitle());
        }
    }

}
