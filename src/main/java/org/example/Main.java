package org.example;


import java.sql.*;
import java.time.Period;

public class Main {
    public static void main(String[] args) throws SQLException {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/jdbc?" + "user=root&password=");
            System.out.println("Successfully connected to DB");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }

        String insertSql = "INSERT INTO persons (firstname, lastname, age) VALUES (?, ?, ?)";
        PreparedStatement insertPerson = connection.prepareStatement(insertSql);

        insertPerson.setString(1, "Simeon");
        insertPerson.setString(2, "Andonov");
        insertPerson.setInt(3,29);
        insertPerson.execute();

        insertPerson.setString(1, "John");
        insertPerson.setString(2, "Sena");
        insertPerson.setInt(3, 22);
        insertPerson.execute();

        insertPerson.setString(1, "Alex");
        insertPerson.setString(2, "Dane");
        insertPerson.setInt(3, 32);
        insertPerson.execute();

        insertPerson.setString(1, "Igor");
        insertPerson.setString(2, "Caran");
        insertPerson.setInt(3, 38);
        insertPerson.execute();


        String updateSql = "UPDATE persons SET lastname = ? WHERE firstname = ?";
        PreparedStatement updatePerson = connection.prepareStatement(updateSql);

        updatePerson.setString(1, "Dostoev");
        updatePerson.setString(2, "Igor");
        updatePerson.executeUpdate();


        String deleteSql = "DELETE FROM persons WHERE firstname = ? AND firstname = ? ";
        PreparedStatement deletePerson = connection.prepareStatement(deleteSql);
        deletePerson.setString(1, "Alex");
        deletePerson.setString(2, "Igor");
        deletePerson.execute();


        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery( "select * from persons");
        while(resultSet.next()) {
            System.out.println("Name: " + resultSet.getString(1) + ", Lastname: " + resultSet.getString(2) + ", Age: " + resultSet.getInt(3));
        }

        resultSet.close();
        statement.close();
        connection.close();





    }
}