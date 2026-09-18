package LibraryManagemt.managers;

import LibraryManagemt.models.Book;

public abstract class LibraryOperations {

    public abstract boolean addBook(Book book);
    public abstract void viewAllBooks();
    public abstract Book searchBookById(int bookId);
    public abstract boolean updateBook(int bookId, String title, String author, double price, double rating, int year);
    public abstract boolean deleteBook(int bookId);
}
