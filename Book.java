public class Book extends Library {
    private String author;

    public Book(String title, String author, String id, int availableCopies) {
        super(title, id, availableCopies);
        setAuthor(author);
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        if  (author == null) {
            throw new IllegalArgumentException("Author cannot be null");
        }
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Book: %s, Author: %s, Available Copies: %d", getTitle(), getAuthor(), getAvailableCopies());
    }
}



