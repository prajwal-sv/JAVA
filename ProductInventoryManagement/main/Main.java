package ProductInventoryManagement.main;

import java.util.Scanner;

import ProductInventoryManagement.managers.ProductManager;
import ProductInventoryManagement.model.Product;

public class Main {

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int choice ;
        do {
           
            System.out.println("\n========== ProdutMangemet ==========");
            System.out.println("1. Add Produt");
            System.out.println("2. View All Produt");
            System.out.println("3. Search Produt by ID");
            System.out.println("4. Update Produt");
            System.out.println("5. Delete Produt");
            System.out.println("6. Sort Produt by Name");
            System.out.println("7. Sort Produt by category");
            System.out.println("8. Sort Produt by Price");
            System.out.println("9. Sort Produt by Rating");
            System.out.println("10. Sort Produt by ID");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");


             System.out.println("Enter your Choise");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("enter id ");
                    int id =  scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("enter name ");
                    String name =  scanner.nextLine();
                    System.out.println("enter category ");
                    String Category = scanner.nextLine();
                    System.out.println("enter price ");
                    double price = scanner.nextDouble();
                    System.out.println("enter quantity ");
                    int quantity =  scanner.nextInt();
                    System.out.println("enter rating");
                    double rating = scanner.nextDouble();

                    Product newProduct = new Product(id, name, Category, price, quantity, rating);

                    if (manager.addProduct(newProduct)) {
                        System.out.println("PRodut in added ");
                        
                    }

                    break;
                case 2:
                    System.out.println("ALl Produt ");
                    manager.viewAllProduct();
                    
                    break;
                case 3:
                    System.out.println("enter the id ");
                    int newid = scanner.nextInt();
                   Product p =  manager.searchProductById(newid);
                   if (p !=null) {
                    System.out.println("Produt find "+p);
                    
                   }else{
                    System.out.println("");
                   }

                  
                    
                    
                    break;
                case 4:
                      System.out.println("enter book id :");
                    int searchid  = scanner.nextInt();
                    scanner.nextLine();

                    if (manager.searchProductById(searchid)!=null) {
                        System.out.println("enter name ");
                    String newname =  scanner.nextLine();
                    System.out.println("enter category ");
                    String newCategory = scanner.nextLine();
                    System.out.println("enter price ");
                    double newprice = scanner.nextDouble();
                    System.out.println("enter quantity ");
                    int newquantity =  scanner.nextInt();
                    System.out.println("enter rating");
                    double newrating = scanner.nextDouble();

                    manager.updateProduct(searchid, newname, newCategory, newprice, newquantity, newrating);
                    System.out.println("produt updated");
                        
                    }else{
                        System.out.println("produt not Found ");
                    }
                    
                    
                    break;
                case 5:
                    System.out.println("enter the produt id for delete");
                    int iddel = scanner.nextInt();

                    if (manager.deleteProduct(iddel)) {
                        System.out.println("produt delted");
                        
                    }else{
                        System.out.println("produt not found ");}
                    
                    break;
                case 6:
                    System.out.println("Sort Produt by Name");
                    manager.sortByProdutName();
                    manager.viewAllProduct();
                    
                    break;
                case 7:
                    manager.sortByCategory();
                    manager.viewAllProduct();
                    
                    break;
                case 8:
                    manager.sortByPrice();
                    manager.viewAllProduct();
                    
                    break;
                case 9:
                    manager.sortByRating();
                    manager.viewAllProduct();
                    
                    break;
                case 10:
                    manager.sortById();
                    manager.viewAllProduct();
                    break;
                case 11:
                    System.out.println("Exiting the System. Goodbye!");

                    
                    break;
            
                default:
                     System.out.println("Invalid choice. Please choose between 1 and 11.");
                    
            }


            
        } while (choice != 11);
        scanner.close();
    }
    
}
