Problem Statement: Create a class Book with attributes title, author, and price. Write a
parameterized constructor to initialize these attributes when a new Book object is created. Also,
provide a copy constructor that creates a new Book object by copying the details from another Book
object. Write a method displayBookDetails() to show the book's information




// Book.java
class Book {
    // Attributes
    String title;
    String author;
    double price;

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Copy constructor
    public Book(Book otherBook) {
        this.title = otherBook.title;
        this.author = otherBook.author;
        this.price = otherBook.price;
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Book Details:");
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("-----------------------");
    }
}

// Main class to test Book class
public class Main {
    public static void main(String[] args) {
        // Using parameterized constructor
        Book book1 = new Book("Java Programming", "John Smith", 450.50);
        book1.displayBookDetails();

        // Using copy constructor
        Book book2 = new Book(book1);
        book2.displayBookDetails();
    }
}
