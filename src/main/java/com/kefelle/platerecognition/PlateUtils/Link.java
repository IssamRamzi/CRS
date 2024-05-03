package com.kefelle.platerecognition.PlateUtils;

import com.kefelle.platerecognition.Closable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Link implements Closable {
    @FXML private TextField plate_number;
    @FXML private TextField user_id;
    public void linkPlate(MouseEvent event) {
        Plate.linkPlate(Integer.parseInt(user_id.getText()), plate_number.getText());
        closeWindow(event);
    }
}
