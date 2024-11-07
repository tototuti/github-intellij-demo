import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Book> books = new ArrayList<>(); // Example book list
    private static BookService bookService = new BookService(books, scanner, false); // Initializing with default isAdmin=false

    public static void main(String[] args) {
        while (true) {
            System.out.print("Are you an Admin (1) or a User (2)? Enter 0 to Exit: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                handleUser(true); // Admin
            } else if (choice == 2) {
                handleUser(false);  // User
            } else if (choice == 0) {
                System.out.println("Exiting program.");
                break;  // Exit the program
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void handleUser(boolean isAdmin) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        User user = new User(name, isAdmin, bookService);  // Assuming User class exists with this constructor

        while (true) {
            if (isAdmin) {
                System.out.print("Admin Menu: (1) View All Books, (2) Add Book, (3) Update Book, (4) Delete Book, (5) Search Book, (0) Back to Main Menu: ");
            } else {
                System.out.print("User Menu: (1) Search Book, (2) Loan Book, (3) Return Book, (0) Back to Main Menu: ");
            }
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                if (isAdmin) {
                    bookService.viewAllBooks();  // Call instance method
                } else {
                    System.out.print("Enter book title to search: ");
                    String title = scanner.nextLine();
                    bookService.searchBook(title);  // Call instance method
                }
            } else if (choice == 2) {
                if (isAdmin) {
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String author = scanner.nextLine();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    bookService.addBook(title, author, quantity);  // Call instance method
                } else {
                    System.out.print("Enter book title to loan: ");
                    String title = scanner.nextLine();
                    bookService.loanBook(title);  // Call instance method
                }
            } else if (choice == 3) {
                if (isAdmin) {
                    System.out.print("Enter the title of the book you want to update: ");
                    String title = scanner.nextLine();
                    bookService.updateBook(title);  // Call instance method
                } else {
                    System.out.print("Enter book title to return: ");
                    String title = scanner.nextLine();
                    bookService.returnBook(title);  // Call instance method
                }
            } else if (choice == 4) {
                if (isAdmin) {
                    System.out.print("Enter the title of the book you want to delete: ");
                    String title = scanner.nextLine();
                    bookService.deleteBook(title);  // Call instance method
                }
            } else if (choice == 0) {
                System.out.println("Returning to main menu.");
                break;  // Exit to main menu
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
