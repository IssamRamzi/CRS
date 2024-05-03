package com.kefelle.platerecognition.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect implements Runnable{
    public static Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "Benahmed2004");
            System.out.println(connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            return connection;
        }
    }
    @Override
    public void run() {
        Connect.connect();
        try {
            Statements.start();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
