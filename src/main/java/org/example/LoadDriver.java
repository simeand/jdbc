package org.example;

import java.sql.*;

public class LoadDriver {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;
        final String url = "jdbc:mysql://localhost:3306/jdbc";
        final String user = "root";
        final String password = "";

        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Successfully connected to DB: jdbc");
        connection.close();
    }
}
