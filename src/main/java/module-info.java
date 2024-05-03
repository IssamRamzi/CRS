module com.kefelle.platerecognition {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.kefelle.platerecognition to javafx.fxml;
    exports com.kefelle.platerecognition;
    exports com.kefelle.platerecognition.UserUtils;
    opens com.kefelle.platerecognition.UserUtils to javafx.fxml;
    exports com.kefelle.platerecognition.PlateUtils;
    opens com.kefelle.platerecognition.PlateUtils to javafx.fxml;
}