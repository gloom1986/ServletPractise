package com.ssergeev.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnector {

    static Properties properties;
    private static final String DATABASE_PROPERTIES_PATH = "database.properties";
    static {
        properties = new Properties();
        InputStream inp = DBConnector.class.getClassLoader().getResourceAsStream(DATABASE_PROPERTIES_PATH);
        if(inp != null) {
            try {
                properties.load(inp);
                inp.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            String url = properties.getProperty("jdbc.url");
            String userName = properties.getProperty("jdbc.userName");
            String password = properties.getProperty("jdbc.password");
            connection = DriverManager.getConnection(url, userName, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
