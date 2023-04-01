package com.peaksoft;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL ="jdbc:postgresql://localhost:5432/sql_practice";
    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "0909";
    public static Connection connection() {
        Connection connection = null;
        try{
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Connected successfully");
        }catch(SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
