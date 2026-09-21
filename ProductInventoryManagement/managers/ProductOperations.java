package ProductInventoryManagement.managers;

import ProductInventoryManagement.model.Product;

public abstract class ProductOperations  {

    public abstract void addProduct(Product product);
    public abstract void viewAllProduct();
    public abstract Product searchProductById(int productId);
    public abstract void updateProduct(int productId,String productName,String category,double price,int quantity,double rating);
    public abstract void deleteProduct(int productId);
    
}
