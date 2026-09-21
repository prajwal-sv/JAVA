package ProductInventoryManagement.managers;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import ProductInventoryManagement.model.Product;

public class ProductManager extends ProductOperations{

    private HashMap<Integer,Product> ProductList = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        // TODO Auto-generated method stub
        if (ProductList.containsKey(product.getProductId())) {

            throw new IllegalArgumentException("Produt With id :"+product.getProductId());
            
        }
        ProductList.put(product.getProductId(), product);
    }
    @Override
    public void viewAllProduct() {
        // TODO Auto-generated method stub
        printProducts(new ArrayList<>(ProductList.values()));
        
        
    }
    public void printProducts(List<Product> list){
        if (list.isEmpty()) {
            System.out.println("no produt in list ");
            return ;
        }
        list.forEach(System.out::println);
    }
    @Override
    public void  updateProduct(int productId, String productName, String category, double price, int quantity,
            double rating) {
       Product p = searchProductById(productId);
       p.setProductName(productName);
       p.setCategory(category);
       p.setPrice(price);
       p.setQuantity(quantity);
       p.setRating(rating);
        
    }
    @Override
    public Product searchProductById(int productId) {
        // TODO Auto-generated method stub
        Product p = ProductList.get(productId);
        if (p==null) {
            throw new IllegalArgumentException("Produt with Id : "+productId+"Not found");
        }
        return p;
    
        
    }
    @Override
    public void deleteProduct(int productId) {
        // TODO Auto-generated method stub
       searchProductById(productId);
       ProductList.remove(productId);
    }

    public List<Product> sortByPrice(){
        // Collections.sort(ProductList , Comparator.comparingDouble(Product::getPrice));
        List<Product> list = new ArrayList<>(ProductList.values());
        list.sort(Comparator.comparingDouble(Product::getPrice));
        return list ;

    }
    public List<Product>  sortByProdutName(){
        List<Product> list = new ArrayList<>(ProductList.values());
        list.sort((a,b)->a.getProductName().compareToIgnoreCase(b.getProductName()));
        return list ;
       
    }
    public List<Product>  sortByRating(){
        List<Product> list = new ArrayList<>(ProductList.values());
        list.sort((a,b)->Double.compare(b.getRating(),a.getRating()));
        return list ;
        
    }
    public List<Product> sortById(){
        List<Product> list = new ArrayList<>(ProductList.values());
        list.sort(Comparator.comparingInt(Product::getProductId));
        return list ;
        
    }
    public List<Product>  sortByCategory(){
        List<Product>  list = new ArrayList<>(ProductList.values());
        list.sort((a,b)->a.getCategory().compareToIgnoreCase(b.getCategory()));
        return list;

    


    
}
}
