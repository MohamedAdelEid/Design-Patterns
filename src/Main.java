public class Main {
    public static void main(String[] args) {
        BookRepository repository = InMemoryBookRepository.getInstance();
        LibraryService library = new LibraryService(repository);

        System.out.println("=== Adding books via Factory ===");
        library.addBook(BookFactory.create(BookType.PHYSICAL, "Harry Potter"));
        library.addBook(BookFactory.create(BookType.EBOOK, "Lord of the Rings"));
        library.addBook(BookFactory.create(BookType.HISTORICAL, "Description of Egypt"));

        User john = new User("John", true);
        User sara = new User("Sara");

        System.out.println("\n=== Catalog ===");
        library.listBooks().forEach(b -> System.out.println(" - " + b.getTitle()));

        System.out.println("\n=== Borrow / return ===");
        library.borrowBook("Harry Potter", john);
        library.borrowBook("Lord of the Rings", sara);
        library.returnBook("Harry Potter");
        library.borrowBook("Harry Potter", sara);

        System.out.println("\n=== Same Singleton instance (shared catalog) ===");
        LibraryService otherDesk = new LibraryService(InMemoryBookRepository.getInstance());
        System.out.println("Books visible from second service: " + otherDesk.listBooks().size());
    }
}
