package com.ssergeev.repository.impl;

import com.ssergeev.entities.Order;
import com.ssergeev.repository.OrderRepository;
import com.ssergeev.util.DBConnector;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private List<Order> orderList;
    private Order order;
    private static final String SELECT_ALL_ORDERS = "SELECT * FROM Orders";
    private static final String SELECT_ORDERS_BY_USER_ID = "SELECT * FROM Orders WHERE user_id=?";
    private static final String INSERT_ORDER = "INSERT INTO Orders (user_id, total_price) VALUES (?, ?)";
    private static final String SELECT_LAST_USER_ORDER_BY_USER_ID = "SELECT * FROM Orders WHERE user_id=? ORDER BY id DESC LIMIT 1";

    private List<Order> getOrdersFromDataBase(ResultSet resultSet) throws SQLException {
        orderList = new ArrayList<>();
        while (resultSet.next()) {
            int receivedId = resultSet.getInt("id");
            int receivedUserId = resultSet.getInt("login");
            double receivedTotalPrice = resultSet.getDouble("total_price");
            orderList.add(new Order(receivedId, receivedTotalPrice));
        }
        return orderList;
    }

    @Override
    public List<Order> getAllOrders() {
        try (
            Connection connection = DBConnector.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_ALL_ORDERS)
        ){
            orderList = getOrdersFromDataBase(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        try (
                Connection connection = DBConnector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ORDERS_BY_USER_ID)
        ){
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            orderList = getOrdersFromDataBase(resultSet);
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    @Override
    public int saveOrder(int userId, double totalPrice) {
        try (
                Connection connection = DBConnector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ORDER,Statement.RETURN_GENERATED_KEYS)
        ){
            preparedStatement.setInt(1, userId);
            preparedStatement.setDouble(2, totalPrice);
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    @Override
    public Optional<Order> getLastUserOrderByUserId(int userId) {
        try (
                Connection connection = DBConnector.getConnection();
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_LAST_USER_ORDER_BY_USER_ID)
        ){
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int receivedId = resultSet.getInt("id");
                int receivedUserId = resultSet.getInt("login");
                double receivedTotalPrice = resultSet.getDouble("total_price");
                order = new Order(receivedId, receivedTotalPrice);
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(order);
    }
}
