package com.ssergeev.util;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@WebListener
public class DBInitializer implements ServletContextListener {

    private static final String CREATE_ITEMS="CREATE TABLE Items (" +
            "id INTEGER NOT NULL AUTO_INCREMENT," +
            "name VARCHAR(255)," +
            "price DOUBLE," +
            "PRIMARY KEY (id));" +
            "INSERT INTO Items (name, price) VALUES ('Book', 5.5);" +
            "INSERT INTO Items (name, price) VALUES ('Matches', 0.5);" +
            "INSERT INTO Items (name, price) VALUES ('Chair', 36.5);" +
            "INSERT INTO Items (name, price) VALUES ('Phone', 99.9);" +
            "INSERT INTO Items (name, price) VALUES ('Bentley', 49990);";

    private static final String CREATE_USERS="CREATE TABLE Users (" +
            "id INTEGER NOT NULL AUTO_INCREMENT," +
            "login VARCHAR(255) UNIQUE," +
            "PRIMARY KEY (id));";

    private static final String CREATE_ORDERS="CREATE TABLE Orders (" +
            "id INTEGER NOT NULL AUTO_INCREMENT," +
            "user_id INTEGER," +
            "total_price DOUBLE," +
            "PRIMARY KEY (id)," +
            "FOREIGN KEY(user_id) REFERENCES Users(id));";

    private static final String CREATE_ORDER_ITEM="CREATE TABLE Order_Item (" +
            "order_id INTEGER," +
            "item_id INTEGER," +
            "FOREIGN KEY(order_id) REFERENCES Orders(id)," +
            "FOREIGN KEY(item_id) REFERENCES Items(id));";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Connection connection = DBConnector.getConnection();
        try {
            Statement statement = connection.createStatement();
            statement.execute(CREATE_ITEMS);
            statement.execute(CREATE_USERS);
            statement.execute(CREATE_ORDERS);
            statement.execute(CREATE_ORDER_ITEM);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
