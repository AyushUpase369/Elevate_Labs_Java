import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);

        library.addBook(new Book(1, "Java"));
        library.addBook(new Book(2, "Python"));
        library.addUser(new User(1, "Ayush"));
        library.addUser(new User(2, "Sumit"));

        while (true) {
            System.out.println("\n1. Show Books\n2. Show Users\n3. Issue Book\n4. Return Book\n5. Exit");
            System.out.print("Choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1 -> library.showBooks();
                case 2 -> library.showUsers();
                case 3 -> {
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    System.out.print("Enter User ID: ");
                    int userId = sc.nextInt();
                    library.issueBook(bookId, userId);
                }
                case 4 -> {
                    System.out.print("Enter Book ID: ");
                    int bookId = sc.nextInt();
                    library.returnBook(bookId);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
