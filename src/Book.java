class Book extends LibraryStock{
    private String author;
    private String genre;

    public Book (String title,String id,String author,String genre){
        super(title,id);
        this.author = author;
        this.genre = genre;
    }
<<<<<<< HEAD

=======
>>>>>>> ec7ca6a5b4b35ca7b39eddf42b022a86578ba0d3
    @Override
    public void displayInfo(){
        System.out.println("Id: "+id+",Author: "+author
                +", Title: "+title+",Genre: "+genre);
    }
}
