package com.ssergeev.services.impl;

import com.ssergeev.entities.Order;
import com.ssergeev.entities.User;
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
    public List<Order> getUserOrders(User user) {
        return orderRepository.getUserOrders(user);
    }

    @Override
    public void saveOrder(Order order) {
        orderRepository.saveOrder(order);
    }

/*    @Override
    public Order getLastUserOrderByUserId(User user) {
        return orderRepository.getLastUserOrder(user).orElseThrow(RuntimeException::new);
    }*/

/*    @Override
    public boolean isUserOrderExist(int userId){
        return orderRepository.getLastUserOrderByUserId(userId).isPresent();
    }*/
}
