import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String memberId;
    private List<Library> borrowedItems = new ArrayList<>();

    public Member(String name, String memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String id) {
        this.memberId = id;
    }

    public List<Library> getBorrowedItems() {
        return borrowedItems;
    }

    public void setBorrowedItems(List<Library> borrowedItems) {
        this.borrowedItems = borrowedItems;
    }

    public void borrowItem(Library item) {
        if (item.getAvailableCopies() == 0) {
            System.out.println(item.getTitle() + " is not available!");
            return;
        }

        if (borrowedItems.size() == 3) {
            System.out.println(name + " cannot borrow more than 3 items!");
            return;
        }
        borrowedItems.add(item);
        item.setAvailableCopies(item.getAvailableCopies() - 1);
        System.out.println(name + " borrowed " + item.getTitle());
    }

    public void returnItem(Library item) {
        if (borrowedItems.contains(item)) {
            borrowedItems.remove(item);
            item.setAvailableCopies(item.getAvailableCopies() + 1);
            System.out.println(name + " returned " + item.getTitle());
        } else {
            System.out.println(name + " has not borrowed " + item.getTitle());
        }
    }

    public void showBorrowedItems() {
        if (borrowedItems.isEmpty()) {
            System.out.println(name + " has not borrowed any items.");
        } else {
            System.out.println(name + " has borrowed:");
            borrowedItems.forEach(i -> System.out.println("- " + i));
        }
    }
    @Override
    public String toString() {
        return "Member{" + "name=" + name + ", borrowedItems=" + borrowedItems + '}';
    }
}
