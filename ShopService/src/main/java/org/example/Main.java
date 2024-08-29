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
        ProductRepo productRepo = new ProductRepo();
        ShopService shopService = new ShopService(orderListRepo,productRepo);

        Product tv = new Product(UUID.randomUUID().toString(), "LG TV", 214.4,1);

        Product laptop = new Product(UUID.randomUUID().toString(),"accer",1541.54,1);

        Product kopfrer = new Product(UUID.randomUUID().toString(),"Litium",154.14,1);

        Product book = new Product(UUID.randomUUID().toString(),"maus",17.54,1);

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