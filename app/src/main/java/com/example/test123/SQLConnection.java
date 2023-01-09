package com.example.test123;

import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SQLConnection {
    public final String url = "jdbc:mysql://127.0.0.1/smig";
    public final String username = "127.0.0.1";
    public final String password = "";

    public Connection connect() {
        Connection conn = null;
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (SQLException e) {
            Toast.makeText(null, e.getMessage(), Toast.LENGTH_SHORT).show();
            Log.e("SQLConnection", "SQLException: " + e.getMessage());
            Log.e("SQLConnection", "SQLState: " + e.getSQLState());
            Log.e("SQLConnection", "VendorError: " + e.getErrorCode());
        } catch (ClassNotFoundException e) {
            Log.e("SQLConnection", "ClassNotFoundException: " + e.getMessage());
        }
        return null;
    }


}