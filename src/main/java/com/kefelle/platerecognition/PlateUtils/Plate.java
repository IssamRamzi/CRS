package com.kefelle.platerecognition.PlateUtils;

import com.kefelle.platerecognition.Database.Connect;
import com.kefelle.platerecognition.UserUtils.User;

import java.sql.*;
import java.util.ArrayList;

public class Plate {
    private static Connection connection = Connect.connect();
    private String PlateNumber;
    private int User_ID;


    public static ArrayList<Plate> platesList = new ArrayList<>();
    public Plate(String plateNumber) {
        PlateNumber = plateNumber;
    }
    public Plate(String plateNumber, int user_ID) {
        PlateNumber = plateNumber;
        User_ID = user_ID;
    }

    public int getUser_ID() {
        return User_ID;
    }

    public void setUser_ID(int user_ID) {
        User_ID = user_ID;
    }

    public String getPlateNumber() {
        return PlateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        PlateNumber = plateNumber;
    }
    public static ArrayList<Plate> getPlatesList() {
        Plate.getPlates();
        return platesList;
    }
    public static void getPlates() {
        try {
            platesList.clear();
            String sql = "SELECT * FROM plate";
            var statement = connection.createStatement();
            statement.execute("use crs");
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                platesList.add(new Plate(resultSet.getString("licence_number"), resultSet.getInt("plate_owner")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static boolean isPlate(String plateNumber) throws SQLException {
        String query = "SELECT * FROM plate WHERE licence_number = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            Statement statement = connection.createStatement();
            statement.execute("use crs");
            stmt.setString(1, plateNumber);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }
            catch (SQLException e){
                System.out.println(e.getMessage());
                return false;
            }
        }
    }
    public static Plate getPlate(String plateNumber) throws SQLException {
        Statement s = connection.createStatement();
        s.execute("use crs");
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM plate where licence_number = ?");
        statement.setString(1, plateNumber);
        ResultSet resultSet = statement.executeQuery();
        System.out.println(resultSet);
        while (resultSet.next()){
            int ID = resultSet.getInt("plate_owner");
            String plate = resultSet.getString("licence_number");
            Plate plate1 = new Plate(plate, ID);
            return plate1;
        }
        return null;
    }

    public static void addPlate(Plate plate) {
        try {
            Statement stmt = connection.createStatement();
            stmt.execute("use crs");
            String sql = "INSERT INTO plate (licence_number, plate_owner) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, plate.getPlateNumber());
            statement.setInt(2, 1);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deletePlate(String licence_number) {
        Plate plate = new Plate(licence_number);
        try {
            if(!isPlate(licence_number)){
                System.out.println("Plate does not exist");
                return;
            }
            Statement stmt = connection.createStatement();
            stmt.execute("use crs");
            String sql = "DELETE FROM plate WHERE licence_number = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, licence_number);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void modifyPlate(String licenceNumber, String newLicenceNumber) {
        try {
            Plate plate = new Plate(licenceNumber);
            if(!isPlate(plate.getPlateNumber())){
                System.out.println("Plate does not exist");
                return;
            }
            Statement stmt = connection.createStatement();
            stmt.execute("use crs");
            String sql = "UPDATE plate SET licence_number = ? WHERE licence_number = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, newLicenceNumber);
            statement.setString(2, licenceNumber);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void linkPlate(int user_ID, String plateNumber){
        try {
            if(!isPlate(plateNumber)){
                System.out.println("Plate does not exist");
                return;
            }
            if(!User.isUser(user_ID)){
                System.out.println("User does not exist");
                return;
            }
            Statement stmt = connection.createStatement();
            stmt.execute("use crs");
            String sql = "UPDATE plate SET plate_owner = ? WHERE licence_number = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, user_ID);
            statement.setString(2, plateNumber);
            statement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "%-5d\t %-30s".formatted(User_ID, PlateNumber);
    }
}
