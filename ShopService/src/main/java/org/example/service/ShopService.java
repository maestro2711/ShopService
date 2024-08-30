package org.example.service;

import org.example.order.Order;
import org.example.order.OrderListRepo;
import org.example.product.Product;
import org.example.product.ProductRepo;

import java.util.Map;

public class ShopService {
    private  ProductRepo productRepo;
    private  OrderListRepo orderListRepo;

    public ShopService( OrderListRepo orderListRepo,ProductRepo productRepo) {

        this.orderListRepo = orderListRepo;
    }

    public boolean placeOrder(Order order) {
        double amount = 0.0;
        //check if all products in the order exist
        for(Product product: order.products()){
            String productName = product.id();
            int quantity = product.stock();
            Product product1 = productRepo.getProductById(productName);
            if(product1 ==null){
                // print message if product does'nt exist
                System.out.println("Product with id" +productName+ " not found");
                return false;
            }
            // check if product availability
            if(product1.stock()<quantity){
                System.out.println("Product with id :" +productName+ " is out of stock") ;
                return false;
            }

            // Calulate Total Price for the Order

            amount +=product1.price()*quantity;
        }

        //update Order with new amount

        order= new Order(order.id(),order.products(),amount);

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
