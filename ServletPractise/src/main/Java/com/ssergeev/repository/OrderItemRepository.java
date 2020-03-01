package com.ssergeev.repository;

import com.ssergeev.entities.Item;

import java.util.List;

public interface OrderItemRepository {

    void saveOrderItem(int orderId, int itemId);

    List<Item> getItemsByOrderId(int orderId);
}
