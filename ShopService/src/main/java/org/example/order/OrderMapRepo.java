package org.example.order;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements OrderRepoInterface{

    private final Map<String,Order> orders = new HashMap<>();

    public OrderMapRepo(Map<String,Order>orders) {

        orders = new HashMap<>();
    }

    @Override
    public Order getOrderById(String id) {
        for(Order order:orders.values()){
            if(order.id().equals(id)){
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getOrders() {
        return new ArrayList<>(orders.values());
    }


    @Override
    public void addOrder(Order order) {
        orders.put(order.id(),order);

    }

    @Override
    public void updateOrder(Order order) {

    }

    @Override
    public void removeOrderById(String id) {
        orders.remove(id);

    }
}
