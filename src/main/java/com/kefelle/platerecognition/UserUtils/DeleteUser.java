package com.kefelle.platerecognition.UserUtils;

import com.kefelle.platerecognition.Closable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.SQLException;

public class DeleteUser implements Closable {
    @FXML
    private TextField username;

    public void deleteUser(MouseEvent event) throws SQLException {
        String us = username.getText();
        User.deleteUser(us);
        username.setText("");
    }
    public void deleteUserClose(MouseEvent event) throws SQLException {
        String us = username.getText();
        User.deleteUser(us);
        this.closeWindow(event);

    }
    public void close(MouseEvent event) {
        this.closeWindow(event);
    }
}
