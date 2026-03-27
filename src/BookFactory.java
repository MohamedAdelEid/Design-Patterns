public final class BookFactory {

    private BookFactory() {
    }

    public static LibraryBook create(BookType type, String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title must not be empty.");
        }
        switch (type) {
            case PHYSICAL:
                return new PhysicalBook(title);
            case EBOOK:
                return new EBook(title);
            case HISTORICAL:
                return new HistoricalBook(title);
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }
}
