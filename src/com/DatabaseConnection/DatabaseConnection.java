package com.DatabaseConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static Connection connection;

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/sampledb";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private DatabaseConnection() {
        // private constructor to prevent instantiation
    }

    public static Connection getConnection() {
        if (connection == null) {
            synchronized (DatabaseConnection.class) {
                if (connection == null) {
                    try {
                        Class.forName(DRIVER);
                        connection = DriverManager.getConnection(URL, USER, PASSWORD);
                    } catch (ClassNotFoundException | SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
}
