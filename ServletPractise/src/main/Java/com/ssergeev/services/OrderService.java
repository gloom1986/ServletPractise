package com.ssergeev.services;

import com.ssergeev.entities.Order;

import java.util.List;

public interface OrderService {

    List<Order> getAllOrders();

    List<Order> getOrdersByUserId(int userId);

    int saveOrder(int userId, double totalPrice);

    Order getLastUserOrderByUserId(int userId);

    boolean isUserOrderExist(int userId);
}
