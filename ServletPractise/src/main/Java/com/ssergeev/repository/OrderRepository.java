package com.ssergeev.repository;

import com.ssergeev.entities.Order;
import com.ssergeev.entities.User;

import java.util.List;

public interface OrderRepository {

    List<Order> getAllOrders();

    List<Order> getUserOrders(User user);

    void saveOrder(Order order);

    /*Optional<Order> getLastUserOrder(User user);*/
}
