package com.kefelle.platerecognition.UserUtils;

import com.kefelle.platerecognition.Database.Connect;

import java.sql.*;
import java.util.ArrayList;


public class User {
    private static Connection connection = Connect.connect();
    public static ArrayList<User> usersList = new ArrayList<>();
    private String Fname,Lname,Username,UserPassword,Email;
    private int ID;
    public User(String fname, String lname, String username, String userPassword, int ID) {
        Fname = fname;
        Lname = lname;
        Username = username;
        UserPassword = userPassword;
        this.ID = ID;
    }
    public User(String fname, String lname, String username, String userPassword, String email, int ID) {
        Fname = fname;
        Lname = lname;
        Username = username;
        UserPassword = userPassword;
        Email = email;
        this.ID = ID;
    }
    public String getFname() {
        return Fname;
    }
    public String getLname() {
        return Lname;
    }
    public String getUsername() {
        return Username;
    }
    public String getUserPassword() {
        return UserPassword;
    }
    public String getEmail() {
        return Email;
    }
    public int getID() {
        return ID;
    }
    public static ArrayList<User> getUsersList() throws SQLException {
        User.getUsers();
        return usersList;
    }
    public void setFname(String fname) {
        Fname = fname;
    }
    public void setLname(String lname) {
        Lname = lname;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String toString(){
        return this.Username + " : "+ this.Fname  + " " + this.Lname + ", " + this.Email + ".\nPassword : "+this.UserPassword +"\n------------";
    }
    public static void printUser() throws SQLException {
        if(usersList.size() == 0)
            User.getUsers();
        for(User u : usersList){
            System.out.println(u);
        }
    }

    public static void getUsers() throws SQLException {
        usersList = new ArrayList<>();
        Statement statement = connection.createStatement();
        statement.execute("use crs");
        String sql = "SELECT * FROM USERS";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int ID = resultSet.getInt("ID");
            String fname = resultSet.getString("Fname");
            String lname = resultSet.getString("lname");
            String username = resultSet.getString("USERNAME");
            String pwd = resultSet.getString("Password");
            String email = resultSet.getString("Email");
            User user = new User(fname,lname,username,pwd,email, ID);
            usersList.add(user);
        }
    }

    public static boolean isUser(String username) throws SQLException {
        String query = "SELECT * FROM users WHERE USERNAME = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            Statement statement = connection.createStatement();
            statement.execute("use crs");
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
                return false;
            }
        }
    }
    public static boolean isUser(int user_id) throws SQLException {
        String query = "SELECT * FROM users WHERE ID = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            Statement statement = connection.createStatement();
            statement.execute("use crs");
            stmt.setInt(1, user_id);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
                return false;
            }
        }
    }

    public static User getUser(String username) throws SQLException {
        Statement s = connection.createStatement();
        s.execute("use crs");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM users where username = ?");
        statement.setString(1, username);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()){
            int ID = resultSet.getInt("ID");
            String fname = resultSet.getString("Fname");
            String lname = resultSet.getString("lname");
            String user = resultSet.getString("USERNAME");
            String pwd = resultSet.getString("Password");
            String email = resultSet.getString("Email");
            User user1 = new User(fname,lname,user,pwd,email, ID);
            return user1;
        }
        return null;
    }

    public static void addUser(User user) throws SQLException {
        // ! Gerer l'ui en affichant que l'utilisateur existe deja
        Statement s = connection.createStatement();
        s.execute("use crs");
        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (Fname, lname, USERNAME, password, Email) VALUES (?, ?, ?, ?, ?)");
            statement.setString(1, user.getFname());
            statement.setString(2, user.getLname());
            statement.setString(3, user.getUsername());
            statement.setString(4, user.getUserPassword());
            statement.setString(5, user.getEmail());
            statement.executeUpdate();
        }catch (SQLIntegrityConstraintViolationException e){
            System.err.println("User "+ user.getUsername() +" already Exists");
            System.out.println(e.getMessage());
        }
    }

    public static void deleteUser(String username) {
        // ! Gerer l'ui en affichant que l'utilisateur n'existe pas
        try{
            Statement s = connection.createStatement();
            s.execute("use crs");
            s.execute("SELECT * FROM users WHERE USERNAME = '"+username +"'");
            if(!s.getResultSet().next()){
                System.err.println("User not found");
                return;
            }
            PreparedStatement statement = connection.prepareStatement("DELETE FROM users WHERE USERNAME = ?");
            statement.setString(1, username);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        System.out.println("User deleted");
    }
    public static void updateUser(User user) {
        try {
            Statement s = connection.createStatement();
            s.execute("use crs");
            s.execute("SELECT * FROM users WHERE USERNAME = '"+user.getUsername() +"'");
            if(!s.getResultSet().next()){
                System.err.println("User not found");
                return;
            }
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET Fname = ?, lname = ?, Password = ?, Email = ? WHERE USERNAME = ?");
            statement.setString(1, user.getFname());
            statement.setString(2, user.getLname());
            statement.setString(3, user.getUserPassword());
            statement.setString(4, user.getEmail());
            statement.setString(5, user.getUsername());
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}

//how can i create a new branch
//git checkout -b branchname
//git add .

//git commit -m "message"
//git push origin branchname

