package com.ssergeev.services;

import com.ssergeev.entities.Order;
import com.ssergeev.entities.User;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    List<Order> getUserOrders(User user);

    void saveOrder(Order order);

//    Order getLastUserOrderByUserId(User user);

//    boolean isUserOrderExist(int userId);
}
