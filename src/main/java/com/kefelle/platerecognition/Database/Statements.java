package com.kefelle.platerecognition.Database;

import com.kefelle.platerecognition.Admin;
import com.kefelle.platerecognition.UserUtils.User;

import java.sql.*;
import java.util.Scanner;

public class Statements {
    public static void start() throws SQLException {
        while (true) {
            menu();
        }
    }
    public static void menu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----DATABASE MANAGEMENT-----");
        System.out.println("[1] - Print Admin ");
        System.out.println("[2] - Print Users ");

        System.out.println(">> ");
        int choice = scanner.nextInt();
        switch (choice){
            case 1 :
                Admin.printAdmin();
                break;
            case 2 :
                User.printUser();
                break;
            case 3 :
                break;
            case 4 :
                break;
            case 5 :
                break;
        }
    }
}
