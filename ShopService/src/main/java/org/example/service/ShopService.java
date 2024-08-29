package org.example.service;

import org.example.order.Order;
import org.example.order.OrderListRepo;
import org.example.product.Product;
import org.example.product.ProductRepo;

public class ShopService {
    //private final ProductRepo productRepo;
    private final OrderListRepo orderListRepo;

    public ShopService( OrderListRepo orderListRepo) {
        //this.productRepo = productRepo;
        this.orderListRepo = orderListRepo;
    }

    public boolean placeOrder(Order order) {
        if (!orderListRepo.getOrders().contains(order)) {
            orderListRepo.addOrder(order);
            System.out.println("Neue Bestellung wurde erfolgreich hinzugefügt.");
            return true;
        } else {
            System.out.println("Diese Bestellung existiert bereits.");
            return false;
        }
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
