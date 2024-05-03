package com.kefelle.platerecognition;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;


public class LogRegController {
    @FXML
    private TextField loginUsername;
    @FXML
    private TextField loginPassword;
    @FXML
    private Text text;
    /*
        todo : attributs
    */
    private Stage stage;
    private Scene scene;
    private Parent root;

    /*
        todo : switch views
    */
    @FXML
    public void changeToDashboard(MouseEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("dashboard/users.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*
        todo : get textfield infos
    */
    public void getLogin(MouseEvent event) throws IOException, SQLException {
        String login, password;
        login = loginUsername.getText();
        password = loginPassword.getText();
        System.out.println(login + " : " + password);
        Admin admin = new Admin(login, password);
        if (Admin.isAdmin(admin))
            changeToDashboard(event);
        else{
            // style it
            text.setStyle("-fx-opacity: 1");
            System.out.println("Not admin");
        }
    }


}
