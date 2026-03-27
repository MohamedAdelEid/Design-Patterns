public abstract class Book implements LibraryBook {
    private String title;
    private boolean isAvailable;

    protected Book(String title) {
        this.title = title;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getTitle() {
        return title;
    }

    public final void borrowBook(User user) {
        if (!isAvailable) {
            System.out.println(title + " is not available.");
            return;
        }

        onBorrow(user);
        isAvailable = false;
    }

    protected abstract void onBorrow(User user);

    public final void returnBook() {
        if (isAvailable) {
            System.out.println(title + " is already in the library.");
            return;
        }
        onReturn();
        isAvailable = true;
    }

    protected void onReturn() {
        System.out.println(title + " has been returned.");
    }
}
