public class Magazine extends Library {
    private String publisher;

    public Magazine(String publisher, String title, String id, int availableCopies) {
        super(title, id, availableCopies);
        setPublisher(publisher);
    }
    public void setPublisher(String publisher) {
        if (publisher == null) {
            throw new IllegalArgumentException("Publisher cannot be null");
        }
        this.publisher = publisher;
    }
    public String getPublisher() {
        return publisher;
    }
    @Override
    public String toString() {
        return String.format("Magazine: %s, Publisher: %s, Available Copies: %d", getTitle(), getPublisher(), getAvailableCopies());
    }
}