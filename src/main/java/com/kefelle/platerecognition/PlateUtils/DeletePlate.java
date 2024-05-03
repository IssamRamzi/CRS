package com.kefelle.platerecognition.PlateUtils;

import com.kefelle.platerecognition.Closable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class DeletePlate implements Closable {
    @FXML private TextField plate;
    public void deletePlate(MouseEvent event) {
        String plate = this.plate.getText();
        Plate.deletePlate(plate);
    }

    public void deletePlateClose(MouseEvent event) {
        String plate = this.plate.getText();
        Plate.deletePlate(plate);
        this.closeWindow(event);
    }

    public void close(MouseEvent event) {
        this.closeWindow(event);
    }

}
