package com.library.servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/library"; // your database
    private static final String USER = "root"; 
    private static final String PASSWORD = "'enter your password'"; 

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver"); // ✅ Recommended for MySQL 8+
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
