import java.util.*;
public class Repository {
    private final List<Library> items = new ArrayList<>();

    public void addItem(Library item) {
        items.add(item);
    }

    public Information findItem(String id) {
        for (Information item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public List<Information> findAllItems() {
        return new ArrayList<>(items);
    }
}
