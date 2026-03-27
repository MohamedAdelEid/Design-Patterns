import java.util.List;
import java.util.Optional;

public class LibraryService {
    private final BookRepository repository;

    public LibraryService(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(LibraryBook book) {
        repository.add(book);
    }

    public Optional<LibraryBook> findBook(String title) {
        return repository.findByTitle(title);
    }

    public List<LibraryBook> listBooks() {
        return repository.findAll();
    }

    public void borrowBook(String title, User user) {
        findBook(title).ifPresentOrElse(
                book -> book.borrowBook(user),
                () -> System.out.println("Book not found.")
        );
    }

    public void returnBook(String title) {
        findBook(title).ifPresentOrElse(
                LibraryBook::returnBook,
                () -> System.out.println("Book not found.")
        );
    }
}
