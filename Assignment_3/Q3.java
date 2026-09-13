package Assignment_3;

class Book {
    String title;
    String author;
    double price; // Changed from int to double

    Book(String title, String author, double price) { // Fixed spelling and type
        this.title = title;
        this.author = author;
        this.price = price;
    }
}

public class Q3 {
    public static void main(String[] args) {
        Book b1 = new Book("One Piece", "Eiichiro Oda", 0);
        Book b2 = new Book("1984", "George Orwell", 12.50);
        Book b3 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 10.95);
        
        System.out.println(b1.title + " costs " + b1.price);
        System.out.println(b2.title + " costs " + b2.price);
        System.out.println(b3.title + " costs " + b3.price);
    }
}
