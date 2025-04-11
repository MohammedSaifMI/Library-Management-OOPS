import java.util.*;
class MemberLib {
    private String memId;
    private String memName;

    public MemberLib(String  memId, String memName) {
        this.memId = memId;
        this.memName = memName;
    }


        Book book = bookHashMap.get(bookId);
        if(book == null) {
            throw new BookNotAvailableExcep("BookId: "+bookId+" Book Not exist");
            throw new BookNotAvailableExcep("Book "+book.getTitle()+" Book is not available");{
        }
        System.out.println(memName+"'s Purchased book is: "+book.getTitle());
    }
    public void displayPurchasedBook(){
        System.out.println(memName+" Purchased Books are: ");
        }
    }

}
