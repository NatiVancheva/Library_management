public class LibraryService {
    private Repository repository;
    private final int MAX_BORROW = 3;

    public LibraryService(Repository repository) {
        this.repository = repository;
    }

    public void borrowItem(Member member, String itemId)
            throws ItemNotAvailableException, MemberLimitExceededException {
        Information item = repository.findItem(itemId);
        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        if (item.getAvailableCopies() <= 0) {
            throw new ItemNotAvailableException(item.getTitle() + " is not available.");
        }

        if (member.getBorrowedItems().size() >= MAX_BORROW) {
            throw new MemberLimitExceededException(member.getName() + " has reached the borrow limit.");
        }

        item.setAvailableCopies(item.getAvailableCopies() - 1);
        System.out.println(member.getName() + " borrowed " + item.getTitle());
    }

    public void returnItem(Member member, String itemId) {
        Information item = repository.findItem(itemId);
        if (item != null) {

            item.setAvailableCopies(item.getAvailableCopies() + 1);
            System.out.println(member.getName() + " returned " + item.getTitle());
        }
    }

    public void printAvailableItems() {
        for (Information item : repository.findAllItems()) {
            System.out.println(item);
        }
    }
}
