// User.java
import java.util.Scanner;

public class User {
    private String name;
    private BookService bookService;


    public User(String name, boolean isAdmin, BookService bookService) {
        this.name = name;
        this.bookService = bookService;
    }
}