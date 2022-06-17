package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.ParkHourApplication;
import com.parkHour.controller.BigController;
import com.parkHour.controller.login.ILogin;
import com.parkHour.controller.login.LoginController;
import com.parkHour.view.interfacciaAmministratore.HomeAmministratore;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class ViewWindow {
    @FXML
    AnchorPane anchorPane;


    private static final ILogin loginController= LoginController.getInstance();

    @FXML
    protected void onHomeClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane, FXMLLoader.load(Objects.requireNonNull(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAmministratore/homeAmm.fxml"))));
    }

    @FXML
    protected void onLogoutClick() throws IOException {
        if(loginController.logout()){
            ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(Objects.requireNonNull(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAutenticazione/viewLogin.fxml"))));
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile inserire un nuovo addetto");
            alert.show();
        }
    }

    @FXML
    protected void initialize() {}


}
