package com.ssergeev.services.impl;

import com.ssergeev.entities.Item;
import com.ssergeev.repository.OrderItemRepository;
import com.ssergeev.services.OrderItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements OrderItemService {

    OrderItemRepository orderItemRepository;

    public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }


    @Override
    public void saveOrderItem(int orderId, int itemId) {
        orderItemRepository.saveOrderItem(orderId, itemId);
    }

    @Override
    public List<Item> getItemsByOrderId(int orderId) {
        return orderItemRepository.getItemsByOrderId(orderId);
    }
}
