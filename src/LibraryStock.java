abstract class LibraryStock {
    protected String title;
    protected String  id;
    protected boolean isAvailable;

    public LibraryStock(String Title, String Id) {
        this.title = Title;
        this.id = Id;
<<<<<<< HEAD
        this.isAvailable = false;
=======
        this.isAvailable = true;
>>>>>>> ec7ca6a5b4b35ca7b39eddf42b022a86578ba0d3
    }

    public String  getId()
    {
        return id;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public String getTitle(){
        return title;
    }

    public abstract void displayInfo();
}
