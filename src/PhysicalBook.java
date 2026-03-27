public class PhysicalBook extends Book {

    public PhysicalBook(String title) {
        super(title);
    }

    @Override
    protected void onBorrow(User user) {
        System.out.println("Physical Book: " + getTitle() + " has been borrowed by " + user.getName() + ".");
    }

    @Override
    protected void onReturn() {
        System.out.println("Physical copy of \"" + getTitle() + "\" placed back on the shelf.");
    }
}
