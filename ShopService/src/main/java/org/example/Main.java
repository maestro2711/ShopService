package org.example;

import org.example.order.Order;
import org.example.order.OrderListRepo;
import org.example.order.OrderMapRepo;
import org.example.product.Product;
import org.example.product.ProductRepo;
import org.example.service.ShopService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        OrderListRepo orderListRepo = new OrderListRepo(new ArrayList<>());

        ShopService shopService = new ShopService(orderListRepo);

        Product tv = new Product(UUID.randomUUID().toString(), "LG TV", 214.4,2);

        Product laptop = new Product(UUID.randomUUID().toString(),"accer",1541.54,2);

        Product kopfrer = new Product(UUID.randomUUID().toString(),"Litium",154.14,1);

        Product book = new Product(UUID.randomUUID().toString(),"maus",17.54,3);

        List<Product> products = new ArrayList<>(List.of(tv,laptop,kopfrer,book));

        double totalAmount = tv.price()* tv.stock() + laptop.price()* laptop.stock()+ book.price()* book.stock() + kopfrer.price()* kopfrer.stock();

        Order myOrder = new Order(
                UUID.randomUUID().toString(),  // Generiert eine zufällige ID als String
                products,
                totalAmount
        );

        System.out.println("Bestellung erstellt: " + myOrder);

        myOrder = new Order(myOrder.id(), products,totalAmount);
        System.out.println("Neue Bestellung:"  +myOrder);

    }
}