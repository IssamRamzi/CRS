package com.kefelle.platerecognition;


import com.kefelle.platerecognition.Database.Connect;
import java.sql.*;

public class Admin {
    private static Connection connection = Connect.connect();
    private String login, password_admin;
    public Admin(String login, String password_admin){
        this.login = login;
        this.password_admin = password_admin;
    }
    public String getLogin(){
        return this.login;
    }
    public String getPassword(){
        return this.password_admin;
    }
    public static boolean isAdmin(Admin admin) throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("use crs");
        String query = "SELECT * FROM ADMIN WHERE LOGIN = ? and PASSWORD = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, admin.getLogin());
            stmt.setString(2, admin.getPassword());
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
        }
    }
    public static void printAdmin() throws SQLException {
        Statement statement = connection.createStatement();
        statement.execute("use crs");
        String sql = "SELECT * FROM ADMIN";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            String login = resultSet.getString("LOGIN");
            String password = resultSet.getString("PASSWORD");
            System.out.println("Login: " + login + ", Password: " + password);
        }
    }
}