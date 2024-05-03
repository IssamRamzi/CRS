package com.kefelle.platerecognition.PlateUtils;

import com.kefelle.platerecognition.Closable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ModifyPlate implements Closable {
    @FXML private TextField licence_number;
    @FXML private TextField new_licence_number;
    public void modifyPlateClose(MouseEvent event) {
        String licence_number = this.licence_number.getText();
        String new_licence_number = this.new_licence_number.getText();
        Plate.modifyPlate(licence_number, new_licence_number);
        this.closeWindow(event);
    }

    public void modifyPlate(MouseEvent event) {
        String licence_number = this.licence_number.getText();
        String new_licence_number = this.new_licence_number.getText();
        Plate.modifyPlate(licence_number, new_licence_number);
    }

    public void close(MouseEvent event) {
        this.closeWindow(event);
    }
}

