package com.kefelle.platerecognition;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class Manual {
    @FXML
    private static ScrollPane scrollPane;
    @FXML
    private static VBox vBox;
    public static void generateManual() {

        System.out.println("This is the manual");
        Text text = new Text("This is the manual");
        vBox.getChildren().add(text);
        scrollPane.setContent(vBox);
    }

}
