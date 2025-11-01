public abstract class Library implements Information {
    protected String title;
    protected String id;
    protected int availableCopies;

    public Library(String title, String id, int availableCopies) {
        setTitle(title);
        setId(id);
        setAvailableCopies(availableCopies);
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be null");
        }
        this.title = title;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Id cannot be null");
        }
        this.id = id;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        if (availableCopies < 0) {
            throw new IllegalArgumentException("AvailableCopies cannot be negative");
        }
        this.availableCopies = availableCopies;
    }

    @Override
    public String toString() {
        return title + " - " + availableCopies + " copies";
    }
}

