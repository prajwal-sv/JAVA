package ProductInventoryManagement.model;

public class Product {

    private int productId;
private String productName;
private String category;
private double price;
private int quantity;
private double rating;
 
  public Product(){}

  public Product(int productId , String productName , String category , double price , int quantity ,double rating ){
    this.category =category;
    this.price =price;
    this.productId = productId ;
    this.productName = productName ;
    this.rating = rating; 
    this.quantity = quantity ;


  }
  public String getCategory() {
      return category;
  }public void setCategory(String category) {
      this.category = category;
  }public double getPrice() {
      return price;
  }public void setPrice(double price) {
    if (price < 0 ) throw new IllegalArgumentException("Price not be negative ") ;
      this.price = price;
  }public int getProductId() {
      return productId;
  }public void setProductId(int productId) {
      this.productId = productId;
  }public String getProductName() {
      return productName;
  }public void setProductName(String productName) {
      this.productName = productName;
  }public int getQuantity() {
      return quantity;
  }public void setQuantity(int quantity) {
    if (quantity < 0) throw new IllegalArgumentException("Quantity cannot be negative");
      this.quantity = quantity;
  }public double getRating() {
    
      return rating;
  }public void setRating(double rating) {
    
if (rating < 0 || rating > 5 ) throw new IllegalArgumentException(" rating not be negative or garter than 5 ") ;
      this.rating = rating;
  }

  @Override
  public String toString() {
      // TODO Auto-generated method stub
      return "Product [" +
                "ID='" + productId + '\'' +
                ", Name='" + productName + '\'' +
                ", Category='" + category + '\'' +
                ", Price=$" + String.format("%.2f", price) +
                ", Quantity=" + quantity +
                ", Rating=" + rating + "/5.0" +
                ']';
  }
    
}
