package com.kefelle.platerecognition.UserUtils;

import com.kefelle.platerecognition.Closable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class ModifyUser implements Closable {
    private @FXML TextField username;
    @FXML private TextField new_fname;
    @FXML private TextField new_lname;
    @FXML private TextField new_userpassword;
    @FXML private TextField new_email;
    private String last = "";
    public void modifyUser(MouseEvent event) throws SQLException {

        String new_username = username.getText();
        String fname = new_fname.getText();
        String lname = new_lname.getText();
        String userpassword = new_userpassword.getText();
        String email = new_email.getText();
        if(fname.isEmpty()) {
            fname = User.getUser(new_username).getFname();
        }
        if(lname.isEmpty()) {
            lname = User.getUser(new_username).getLname();
        }
        if(userpassword.isEmpty()) {
            userpassword = User.getUser(new_username).getUserPassword();
        }
        if(email.isEmpty()) {
            email = User.getUser(new_username).getEmail();
        }

        User user = new User(fname,lname,new_username,userpassword,email,1);
        User.updateUser(user);
    }
    public void modifyUserClose(MouseEvent event) throws SQLException {

        String new_username = username.getText();
        String fname = new_fname.getText();
        String lname = new_lname.getText();
        String userpassword = new_userpassword.getText();
        String email = new_email.getText();
        if(fname.isEmpty()) {
            fname = User.getUser(new_username).getFname();
        }
        if(lname.isEmpty()) {
            lname = User.getUser(new_username).getLname();
        }
        if(userpassword.isEmpty()) {
            userpassword = User.getUser(new_username).getUserPassword();
        }
        if(email.isEmpty()) {
            email = User.getUser(new_username).getEmail();
        }

        User user = new User(fname,lname,new_username,userpassword,email,1);
        User.updateUser(user);
        this.closeWindow(event);
    }
    public void close(MouseEvent event) {
        this.closeWindow(event);
    }
    public void displayUserK(KeyEvent event) {
        try {
            String new_username = username.getText();
            if (new_username.isEmpty()) {
                new_fname.setText("");
                new_lname.setText("");
                new_userpassword.setText("");
                new_email.setText("");
                return;
            }
            if (!new_username.equals(last)) {
                last = new_username;
                User user = User.getUser(new_username);
                new_fname.setText(user.getFname());
                new_lname.setText(user.getLname());
                new_userpassword.setText(user.getUserPassword());
                new_email.setText(user.getEmail());
            }
        } catch (Exception e) {
            // Handle exceptions appropriately
        }
    }
}
