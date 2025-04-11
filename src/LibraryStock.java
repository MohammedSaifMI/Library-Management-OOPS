abstract class LibraryStock {
    protected String title;
    protected String  id;
    protected boolean isAvailable;

    public LibraryStock(String Title, String Id) {
        this.title = Title;
        this.id = Id;
        this.isAvailable = false;

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
