import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryBookRepository implements BookRepository {
    private static final class Holder {
        private static final InMemoryBookRepository INSTANCE = new InMemoryBookRepository();
    }

    private final List<LibraryBook> books = new ArrayList<>();

    private InMemoryBookRepository() {
    }

    public static InMemoryBookRepository getInstance() {
        return Holder.INSTANCE;
    }

    @Override
    public void add(LibraryBook book) {
        books.add(book);
    }

    @Override
    public List<LibraryBook> findAll() {
        return new ArrayList<>(books);
    }

    @Override
    public Optional<LibraryBook> findByTitle(String title) {
        return books.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst();
    }
}
