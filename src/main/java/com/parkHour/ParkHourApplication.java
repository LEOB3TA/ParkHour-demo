package com.parkHour;

import com.parkHour.controller.BigController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ParkHourApplication extends Application {

    public static Scene scene;
    private static BigController bigController;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ParkHourApplication.class.getResource("/parkHour.view.interfacciaAutenticazione/viewLogin.fxml"));
        scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        bigController=new BigController();
        launch();
    }

    public static void setRoot(AnchorPane pane, Parent parent) {
        pane.getChildren().clear();
        scene.setRoot(parent);
    }
}