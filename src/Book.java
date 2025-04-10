class Book extends LibraryStock{
    private String author;
    private String genre;

    public Book (String title,String id,String author,String genre){
        super(title,id);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public void displayInfo(){
        System.out.println("Id: "+id+",Author: "+author
                +", Title: "+title+",Genre: "+genre);
    }
}
