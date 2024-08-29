package org.example.order;

import java.util.List;

public interface OrderRepoInterface {

     Order getOrderById(String id);

     List<Order> getOrders();
     void addOrder(Order order);
     void  updateOrder(Order order);
     void removeOrderById(String id);
}
