package com.ssergeev.services;

import com.ssergeev.entities.Item;

import java.util.List;

public interface OrderItemService {

    void saveOrderItem(int orderId, int itemId);

    List<Item> getItemsByOrderId(int orderId);
}
