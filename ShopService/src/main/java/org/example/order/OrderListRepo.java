package org.example.order;

import org.example.product.Product;

import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements OrderRepoInterface {
    private final List<Order>orders = new ArrayList<>();


    public OrderListRepo(ArrayList<Order> orders) {
    }

    @Override
    public List<Order>getOrders(){
        return orders;
    }
      @Override
    public Order getOrderById(String id){
        for(Order order:orders){
            if(order.id().equals(id)){
                return order;
            }
        }
        return null;
    }
    @Override
    public void addOrder(Order order){
        orders.add(order);
    }

    @Override
    public void updateOrder(Order order){
        int index= orders.indexOf(order);
        orders.set(index,order);

    }


    @Override
    public void removeOrderById(String id){
        orders.removeIf(order -> order.id().equals(id));
    }

    public void removeAllOrders(){
        orders.clear();
    }
}
