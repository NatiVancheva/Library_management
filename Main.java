
public class Main {
    public static void main(String[] args) {
        Repository repo = new Repository();
        LibraryService service = new LibraryService(repo);

        Book book1 = new Book("Clean Code", "Robert C. Martin", "B001", 2);
        Magazine mag1 = new Magazine("National Geographic", "NatGeo", "M001", 1);

        repo.addItem(book1);
        repo.addItem(mag1);

        Member John = new Member("John Doe", "M100");

        try {
            service.borrowItem(John, "B001");
            service.borrowItem(John, "M001");
            service.printAvailableItems();

            service.returnItem(John, "B001");
            service.printAvailableItems();
        } catch (ItemNotAvailableException | MemberLimitExceededException e) {
            System.err.println("Error: " + e.getMessage());
        }

        John.showBorrowedItems();
    }
}



