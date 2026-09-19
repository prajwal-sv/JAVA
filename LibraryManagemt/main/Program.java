package LibraryManagemt.main;

import java.util.Scanner;

import LibraryManagemt.managers.BookManager;
import LibraryManagemt.models.Book;

public class Program {


    public static void main(String[] args) {
      BookManager manager = new BookManager();
    Scanner scanner =  new Scanner(System.in);
    int choice;
    do{
        System.out.println("\n========== LIBRARY MANAGEMENT SYSTEM ==========");
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book by ID");
            System.out.println("4. Update Book");
            System.out.println("5. Delete Book");
            System.out.println("6. Sort Books by Title");
            System.out.println("7. Sort Books by Author");
            System.out.println("8. Sort Books by Price");
            System.out.println("9. Sort Books by Rating");
            System.out.println("10. Sort Books by Publication Year");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

        choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("enter id");
                int id = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter Title: ");
                String title = scanner.nextLine();

                System.out.print("Enter Author: ");
                String author = scanner.nextLine();

                System.out.print("Enter Price: ");
                double price = scanner.nextDouble();

                System.out.print("Enter Rating (0.0 to 5.0): ");
                double rating = scanner.nextDouble();

                System.out.print("Enter Publication Year: ");
                int year = scanner.nextInt();

                Book newBook = new Book(id,title ,author,price,rating,year);

                if (manager.addBook(newBook)) {
                    System.out.println("Book added successfully");
                    
                    
                }
                
                break;

            case 2:
                System.out.println("ALl Books ");
                manager.viewAllBooks();
                break;
            case 3 :
                System.out.print("Enter Book ID to search: ");
                int searchid =  scanner.nextInt();
                Book finBook = manager.searchBookById(searchid);
                if (finBook !=null) {

                    System.out.println("Book find "+finBook);

                    
                }else{
                    System.out.println("Book not found with ID: " + searchid);
                }
                break;
            
            case 4:
                System.out.print("Enter Book ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                if (manager.searchBookById(updateId) != null) {
                        System.out.print("Enter New Title: ");
                        String newTitle = scanner.nextLine();

                        System.out.print("Enter New Author: ");
                        String newAuthor = scanner.nextLine();

                        System.out.print("Enter New Price: ");
                        double newPrice = scanner.nextDouble();

                        System.out.print("Enter New Rating: ");
                        double newRating = scanner.nextDouble();

                        System.out.print("Enter New Publication Year: ");
                        int newYear = scanner.nextInt();

                        manager.updateBook( updateId,newTitle, newAuthor, newPrice, newRating, newYear);
                        System.out.println("Book ID not found!");

                }else{
                    System.out.println("book id not found");
                }
                break;
            case 5:
                System.out.print("Enter Book ID to delete: ");
                    int deleteId = scanner.nextInt();
                    if (manager.deleteBook(deleteId)) {
                        System.out.println("Book deleted successfully!");
                    } else {
                        System.out.println("Book ID not found!");
                    }
                    break;

            case 6:
                    manager.sortByTitle();
                    manager.viewAllBooks();
                    break;

                case 7:
                    manager.sortByAuthor();
                    manager.viewAllBooks();
                    break;

                case 8:
                    manager.sortByPrice();
                    manager.viewAllBooks();
                    break;

                case 9:
                    manager.sortByRating();
                    manager.viewAllBooks();
                    break;

                case 10:
                    manager.sortByPublicationYear();
                    manager.viewAllBooks();
                    break;

                case 11:
                    System.out.println("Exiting the System. Goodbye!");
                    break;

            




        
            default:
                System.out.println("Invalid choice. Please choose between 1 and 11.");
        }

    }while(choice !=11);  

    scanner.close();
    }
    
    
}  
