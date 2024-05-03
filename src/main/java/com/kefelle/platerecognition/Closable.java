package com.kefelle.platerecognition;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;

public interface Closable {
    @FXML
    default void closeWindow(MouseEvent event) {
        ((Node)(event.getSource())).getScene().getWindow().hide();
    }
}
