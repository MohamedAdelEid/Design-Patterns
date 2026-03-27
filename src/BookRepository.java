import java.util.List;
import java.util.Optional;

public interface BookRepository {
    void add(LibraryBook book);
    List<LibraryBook> findAll();
    Optional<LibraryBook> findByTitle(String title);
}
