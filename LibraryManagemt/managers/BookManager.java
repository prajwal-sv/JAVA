package LibraryManagemt.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import LibraryManagemt.models.Book;

public class BookManager extends LibraryOperations{
    ArrayList<Book> booklList= new ArrayList<>();

    @Override
    public boolean addBook(Book book) {
        // TODO Auto-generated method stub

        if (searchBookById(book.getBookId()) != null ){

            System.out.println("this book was already exits "+book.getBookId());

            return false ;
            
        }

        booklList.add(book);

        return true;
    }
    @Override
    public boolean deleteBook(int bookId) {

        if (searchBookById(bookId) != null ){

            booklList.remove(bookId);

            System.out.println("Book was deleted id is : "+ bookId);


            return true ;
            
        }
        
        return false;
    }
    @Override
    public Book searchBookById(int bookId) {
        // TODO Auto-generated method stub

        for (Book book : booklList) {

            if (book.getBookId() == bookId) {

                return book ;
                
            }
            
        }
        return null;
    }
    @Override
    public void viewAllBooks() {
        // TODO Auto-generated method stub

        if (booklList.isEmpty()) {

            System.out.println("there is no book in the lab ");
            return ;
        }
        for (Book book : booklList) {
            System.out.println(book);
        }
        
    }
    @Override
    public boolean updateBook(int bookId, String title, String author, double price, double rating, int year) {
        // TODO Auto-generated method stub

        Book b=  searchBookById(bookId);
       if (b!=null) {
        b.setAuthor(author);
        b.setPrice(price);
        b.setTitle(title);
        b.setRating(rating);
        b.setPublicationYear(year);

        return  true ;
       }
        
        return false;
    }
    
    public void sortByTitle() {
        // Lambda expression implementation of Comparator<Book>
        Collections.sort(booklList, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));
        System.out.println("Books sorted by Title successfully.");
    }

    public void sortByAuthor() {
        Collections.sort(booklList, (b1, b2) -> b1.getAuthor().compareToIgnoreCase(b2.getAuthor()));
        System.out.println("Books sorted by Author successfully.");
    }

    public void sortByPrice() {
        Collections.sort(booklList, Comparator.comparingDouble(Book::getPrice));
        System.out.println("Books sorted by Price successfully.");
    }

    public void sortByRating() {
        // Sorting in descending order (highest rating first)
        Collections.sort(booklList, (b1, b2) -> Double.compare(b2.getRating(), b1.getRating()));
        System.out.println("Books sorted by Rating (Highest first) successfully.");
    }
    public void sortByPublicationYear() {
        Collections.sort(booklList, Comparator.comparingInt(Book::getPublicationYear));
        System.out.println("Books sorted by Publication Year successfully.");
    }



    }






