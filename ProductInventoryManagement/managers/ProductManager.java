package ProductInventoryManagement.managers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import ProductInventoryManagement.model.Product;

public class ProductManager extends ProductOperations{

    ArrayList<Product> ProductList = new ArrayList<>();

    @Override
    public boolean addProduct(Product product) {
        // TODO Auto-generated method stub
        if (searchProductById(product.getProductId()) == product) {

            System.out.println("Produt already listed");

            return false ;
            
        }
        ProductList.add(product);
        
        return true;
    }
    @Override
    public void viewAllProduct() {
        // TODO Auto-generated method stub
        if (ProductList.isEmpty()) {
            System.out.println("no produt in list ");
            return ;
        }
        for (Product product : ProductList) {
         System.out.println(product);

         
        }
        
    }
    @Override
    public boolean updateProduct(int productId, String productName, String category, double price, int quantity,
            double rating) {
        // TODO Auto-generated method stub
        for (Product product : ProductList) {
            if (product.getProductId() == productId) {

                product.setPrice(price);
                product.setCategory(category);
                product.setProductName(productName);
                product.setQuantity(quantity);
                product.setRating(rating);

                return true ;
                
            }
        }

       
        return false;
    }
    @Override
    public Product searchProductById(int productId) {
        // TODO Auto-generated method stub
        for (Product product : ProductList) {
            if (product.getProductId() == productId) {
                return product ;
                
                
            }
        }
        return null;
    }
    @Override
    public boolean deleteProduct(int productId) {
        // TODO Auto-generated method stub
        Product p = searchProductById(productId);
         if (p !=null) {
            return ProductList.remove(p);
         }
        
        return false;
    }

    public void sortByPrice(){
        Collections.sort(ProductList , Comparator.comparingDouble(Product::getPrice));

    }
    public void sortByProdutName(){
        Collections.sort(ProductList,(p1,p2)->p1.getProductName().compareToIgnoreCase(p2.getProductName()));
    }
    public void sortByRating(){
         Collections.sort(ProductList,(p1,p2)->Double.compare(p2.getRating(),p1.getRating()));
        
    }
    public void sortById(){
        Collections.sort(ProductList , Comparator.comparingInt(Product::getProductId));
        
    }
    public void sortByCategory(){
        Collections.sort(ProductList,(p1,p2)->p1.getCategory().compareToIgnoreCase(p2.getCategory()));
        
    }

    


    
}
