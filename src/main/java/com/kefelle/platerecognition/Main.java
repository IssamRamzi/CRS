package com.kefelle.platerecognition;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import com.kefelle.platerecognition.Database.Connect;

import java.io.File;


public class Main extends Application {
    private static Connect connect = new Connect();
    @Override
    public void start(Stage stage) throws Exception {
//        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("dashboard/plates.fxml"));

        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("AdminPa/users.fxml"));
        try{
            Scene scene = new Scene(fxmlLoader.load());
            Image icon = new Image(new File("src/main/resources/com/kefelle/platerecognition/assets/images/crs.png").toURI().toString());
            stage.getIcons().add(icon);
            stage.setResizable(false);
            stage.setTitle("Plate Recognition System");
            stage.setScene(scene);
            stage.show();
        }catch (Exception e){
            System.out.println(e);
        }

    }
    public static void main(String[] args){
        Thread thread = new Thread(connect);
        thread.start();
        launch();


    }
}