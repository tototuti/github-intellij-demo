import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class BookService {
    private Scanner scanner;
    private boolean isAdmin;
    private List<Book> books;

    public BookService(List<Book> books, Scanner scanner, boolean isAdmin) {
       if (books != null) {
           this.books = books; this.scanner = scanner;
       } else { this.isAdmin = isAdmin;
    }      this.books = new ArrayList<>();
       }
    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooks() {
        return books;
    }

    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getNbook().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public boolean updateBook(String oldTitle, String newTitle, String newAuthor, int newQuantity) {
        for (Book book : books) {
            if (book.getNbook().equalsIgnoreCase(oldTitle)) {
                book.setNbook(newTitle);
                book.setAuthorName(newAuthor);
                book.setQuantity(newQuantity);
                return true;
            }
        }
        return false;
    }

    public boolean deleteBooks(String title) {
        return books.removeIf(book -> book.getNbook().equalsIgnoreCase(title));
    }

    // View all books
    public void viewAllBooks() {
        for (Book book : this.getBooks()) {
            book.displayBookInfo();
        }
    }

    // Add a book
    public void addBook(String title, String author, int quantity) {
        Book book = new Book(title, author, quantity);
        this.addBook(book);
        System.out.println("Book added successfully.");
    }

    // Search for a book by title
    public void searchBook(String title) {
        Book book = this.getBookByTitle(title);
        if (book != null) {
            book.displayBookInfo();
        } else {
            System.out.println("Book not found.");
        }
    }

    // Loan a book
    public void loanBook(String title) {
        Book book = this.getBookByTitle(title);
        if (book != null && book.loanBook()) {
            System.out.println("Book loaned successfully.");
        } else {
            System.out.println("Sorry, the book is unavailable.");
        }
    }

    // Return a book
    public void returnBook(String title) {
        Book book = this.getBookByTitle(title);
        if (book != null) {
            book.returnBook();
            System.out.println("Book returned successfully.");
        } else {
            System.out.println("Book not found.");
        }
    }

    // Admin-only method to update book info
    public void updateBook(String oldTitle) {
        if (isAdmin) {
            System.out.print("Enter new title: ");
            String newTitle = scanner.nextLine();
            System.out.print("Enter new author: ");
            String newAuthor = scanner.nextLine();
            System.out.print("Enter new quantity: ");
            int newQuantity = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (this.updateBook(oldTitle, newTitle, newAuthor, newQuantity)) {
                System.out.println("Book updated successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } else {
            System.out.println("You are not authorized to update books.");
        }
    }

    // Admin-only method to delete a book
    public void deleteBook(String title) {
        if (isAdmin) {
            if (this.deleteBooks(title)) {
                System.out.println("Book deleted successfully.");
            } else {
                System.out.println("Book not found.");
            }
        } else {
            System.out.println("You are not authorized to delete books.");
        }
    }
}
