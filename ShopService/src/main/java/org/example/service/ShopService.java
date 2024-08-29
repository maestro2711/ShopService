package org.example.service;

import org.example.order.Order;
import org.example.order.OrderListRepo;
import org.example.product.Product;
import org.example.product.ProductRepo;

public class ShopService {
    private  ProductRepo productRepo;
    private  OrderListRepo orderListRepo;

    public ShopService( OrderListRepo orderListRepo,ProductRepo productRepo) {

        this.orderListRepo = orderListRepo;
    }

    public boolean placeOrder(Order order) {
        //check if all products in the order exist
        for(Product product: order.products()){
            Product product1 = productRepo.getProductById(product.id());
            if(product1 ==null){
                // print message if product does'nt exist
                System.out.println("Product with id" +product+ " not found");
                return false;
            }
            // check if product availability
            if(product1.stock()<1){
                System.out.println("Product with id :" +product+ " is out of stock") ;
                return false;
            }
        }

        //All products exist and ar in stock, add the order
        orderListRepo.addOrder(order);
        System.out.println("Order placed successfully");

        return true;
    }

    /*public boolean addProduct(Product product) {
        if (!orderListRepo.getProducts().contains(product)) {
            orderListRepo.addProduct(product);
            System.out.println("Neues Produkt wurde erfolgreich hinzugefügt.");
            return true;
        } else {
            System.out.println("Dieses Produkt existiert bereits.");
            return false;
        }
    }*/
}
