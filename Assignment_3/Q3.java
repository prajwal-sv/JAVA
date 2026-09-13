package Assignment_3;
 
class Book {
    private  String title , author , publisher , isbn ;
    private int year , quantity ;
    private double price;

    Book(String title , String author , String publisher , String isbn ,int year , double price  , int quantity){

                      this.year = year;
                      this.title = title;
                      this.publisher = author;
                      this.publisher = publisher ;
                      this.isbn = isbn ;
                      this.year = year ;
                      this.price = price ;
                      this.quantity = quantity ;
                      


    }

       public String getTitle() { return title; } 
       public void setTitle(String title) { this.title = title; }
       public String getAuthor() { return author; }
       public void setAuthor(String author) { this.author = author; }
       public String getPublisher() { return publisher; } 
       public void setPublisher(String publisher) { this.publisher = publisher; } 
       public String getIsbn() { return isbn; } 
       public void setIsbn(String isbn) { this.isbn = isbn; } 
       public int getYear() { return year; } 
       public void setYear(int year) { this.year = year; } 
       public double getPrice() { return price; } 
       public void setPrice(double price) { this.price = price; } 
       public int getQuantity() { return quantity; } 
       public void setQuantity(int quantity) { this.quantity = quantity; }




       public void increaseQunatity(int q){
        quantity += q ;

       }
       public void decreaseQuantity(int q){
        quantity += q ;
        
       }
       public Double getInventoryValue(){
        return  price*quantity;
        
       }




    

}

public class Q3 {
    
    public static void main(String[] args) {


        Book b = new Book("Java","James","ABC","12345",2024,500,22);

        b.increaseQunatity(5);
        b.decreaseQuantity(2);

        System.out.println("Inventory Value : "+ b.getInventoryValue());






    }
}
