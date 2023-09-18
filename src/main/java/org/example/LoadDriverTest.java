package org.example;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoadDriverTest {
        public static void main(String[] args) throws SQLException {

            Connection connection = null;
            final String url = "jdbc:mysql://localhost:3306/test";
            final String user = "root";
            final String password = "";

            try {
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Successfully connected to DB: test");
            connection.close();
        }
    }
