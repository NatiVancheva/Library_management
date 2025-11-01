public interface Information {
    String getTitle();
    String getId();
    int getAvailableCopies();
    void setAvailableCopies(int availableCopies);
    String toString();
}