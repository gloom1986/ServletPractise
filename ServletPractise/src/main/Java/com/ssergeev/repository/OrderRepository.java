package com.ssergeev.repository;

import com.ssergeev.entities.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Order> getAllOrders();

    List<Order> getOrdersByUserId(int userId);

    int saveOrder(int userId, double totalPrice);

    Optional<Order> getLastUserOrderByUserId(int userId);
}
