package com.ssergeev.services.impl;

import com.ssergeev.entities.Order;
import com.ssergeev.repository.OrderRepository;
import com.ssergeev.services.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private  OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.getAllOrders();
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        return orderRepository.getOrdersByUserId(userId);
    }

    @Override
    public int saveOrder(int userId, double totalPrice) {
        orderRepository.saveOrder(userId, totalPrice);
        return userId;
    }

    @Override
    public Order getLastUserOrderByUserId(int userId) {
        return orderRepository.getLastUserOrderByUserId(userId).orElseThrow(RuntimeException::new);
    }

    @Override
    public boolean isUserOrderExist(int userId){
        return orderRepository.getLastUserOrderByUserId(userId).isPresent();
    }
}
