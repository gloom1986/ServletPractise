package com.ssergeev.repository.impl;

import com.ssergeev.entities.Item;
import com.ssergeev.repository.OrderItemRepository;
import com.ssergeev.util.DBConnector;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class OrderItemRepositoryImpl implements OrderItemRepository {

    private List<Item> itemList;
    private Item item;
    private static final String SET_ORDER_ITEM = "INSERT INTO Order_Item VALUES (?, ?)";
    private static final String SELECT_ORDER_ITEM_BY_ORDER_ID = "SELECT * FROM Order_Item WHERE order_id=?";

    // SELECT i.name, i.price
    // FROM Orders AS o
    //   INNER JOIN Order_Item AS oi ON o.id = oi.order_id
    //   INNER JOIN Items AS i ON i.id = oi.item_id
    // WHERE o.id = ?

    @Override
    public void saveOrderItem(int orderId, int itemId) {
        try (
                Connection connection = DBConnector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SET_ORDER_ITEM)
        ){
            preparedStatement.setInt(1, orderId);
            preparedStatement.setInt(2, itemId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> getItemsByOrderId(int orderId) {
        try (
                Connection connection = DBConnector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDER_ITEM_BY_ORDER_ID)
        ){
            preparedStatement.setInt(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String receivedItemName = resultSet.getString(0);
                double receivedItemPrice = resultSet.getDouble(1);
                item = new Item(receivedItemName, receivedItemPrice);
                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return itemList;
    }


}
