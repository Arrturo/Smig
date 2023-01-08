package com.example.test123;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLConnection {
    public String url = "jdbc:mysql://127.0.0.1:3306/smig";
    public String username = "root@localhost";
    public String password = "";

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to the database!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("chuj");
        }
    }
}