import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.getTitle());
    }

    public void addUser(User user) {
        users.add(user);
        System.out.println("User added: " + user.getName());
    }

    public void issueBook(int bookId, int userId) {
        Book book = findBook(bookId);
        User user = findUser(userId);

        if (book == null) {
            System.out.println("This Book is not found.");
            return;
        }
        if (user == null) {
            System.out.println("This User not found.");
            return;
        }
        if (book.isIssued()) {
            System.out.println("This Book already issued.");
        } else {
            book.setIssued(true);
            System.out.println("Book '" + book.getTitle() + "' issued to " + user.getName());
        }
    }

    public void returnBook(int bookId) {
        Book book = findBook(bookId);

        if (book == null) {
            System.out.println("This Book is not found.");
            return;
        }
        if (!book.isIssued()) {
            System.out.println("This Book is not issued.");
        } else {
            book.setIssued(false);
            System.out.println("Book '" + book.getTitle() + "' is returned.");
        }
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void showUsers() {
        for (User user : users) {
            System.out.println(user);
        }
    }

    private Book findBook(int id) {
        for (Book b : books) {
            if (b.getId() == id) return b;
        }
        return null;
    }

    private User findUser(int id) {
        for (User u : users) {
            if (u.getId() == id) return u;
        }
        return null;
    }
}
