package org.example.product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private final List<Product> products ;

    public ProductRepo() {
        products = new ArrayList<>();
    }

    public List<Product>getProducts(){
        return products;
    }

    public Product  getProductById(String id){
        for(Product product: products){
            if(product.id().equals(id)){
                return product;

            }
        }
        return null;
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public void removeProductById(int id){
        products.remove(id);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }
}
