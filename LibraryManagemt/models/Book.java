package LibraryManagemt.models;

public class Book {
    private int bookId;
    private String title;
    private String author;
    private double price;
    private double rating;
    private int publicationYear;

    public Book(){

    }
    public Book(int bookId, String title, String author, double price, double rating, int publicationYear){


        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.price = price;
        this.rating = rating;
        this.publicationYear = publicationYear;
        
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }public int getPublicationYear() {
        return publicationYear;
    }public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }public double getRating() {
        return rating;
    }public void setRating(double rating) {
        this.rating = rating;
    }public String getTitle() {
        return title;
    }public void setTitle(String title) {
        this.title = title;
    }

    @Override
     public String toString() {
        return String.format("ID: %-4d | Title: %-20s | Author: %-15s | Price: $%-6.2f | Rating: %-3.1f | Year: %d",
                bookId, title, author, price, rating, publicationYear);
    }
}
