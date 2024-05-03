package com.kefelle.platerecognition.PlateUtils;

import com.kefelle.platerecognition.Closable;
import com.kefelle.platerecognition.UserUtils.User;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AddPlate implements Closable {
    @FXML
    private TextField licence_number;
    public void addPlate(MouseEvent event) {
        String licence_number = this.licence_number.getText();
        Plate plate = new Plate(licence_number);
        Plate.addPlate(plate);
    }
    public void addPlateClose(MouseEvent event) {
        String licence_number = this.licence_number.getText();
        this.closeWindow(event);
        Plate plate = new Plate(licence_number);
        Plate.addPlate(plate);
    }
    public void close(MouseEvent event) {
        this.closeWindow(event);
    }

}
