package com.example2;

import java.sql.*;

public class testoke {
    public static void main(String[] args){
        // SQL query to fetch all users
        String sqlSelectAllPersons = "SELECT * FROM users";
        
        // Database connection URL
        String connectionUrl = "jdbc:mysql://localhost:3306/db_bendicar";

        // Use try-with-resources to automatically close resources
        try (Connection conn = DriverManager.getConnection(connectionUrl, "root", "");
             PreparedStatement ps = conn.prepareStatement(sqlSelectAllPersons);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("Koneksi Berhasil");

            // Iterate through the result set and print each user's username
            while (rs.next()) {
                String name = rs.getString("password"); // Assuming column name is 'username'
                System.out.println(name);
            }

        } catch (SQLException e) {
            // Print detailed error message for debugging
            System.err.println("Error connecting to the database or executing the query:");
            e.printStackTrace();
        }
    }
}
