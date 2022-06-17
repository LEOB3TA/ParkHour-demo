package com.parkHour.view.interfacciaAutenticazione;


import com.parkHour.ParkHourApplication;
import com.parkHour.controller.login.ILogin;
import com.parkHour.controller.login.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;


public class ViewLogin {
    private Button login;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Label error;


    public ViewLogin() {
        ILogin loginController = LoginController.getInstance();
    }
/*commentato soltanto per fare il fast login,( entrre sen<a credenziali)
    @FXML
    public void onLoginButtonClick() throws IOException {
        Alert alert=new Alert(Alert.AlertType.ERROR);
        if(username.getText().isEmpty()||password.getText().isEmpty()){
            alert.setContentText("i campi non possono essere vuoti");
            alert.show();
        }else{
            if(loginController.login(username.getText(), password.getText())==0){
                ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(ViewLogin.class.getResource("/parkHour.view.interfacciaAmministratore/homeAmm.fxml")));
            }
            else if(loginController.login(username.getText(), password.getText())==1){
                ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(ViewLogin.class.getResource("/parkHour.view.interfacciaAddetto/homeAddetto.fxml")));
            }
            else{
                alert.setContentText("username o password errata");
                alert.show();
            }
        }
    }
 */
    @FXML
    public void onLoginButtonClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(Objects.requireNonNull(ViewLogin.class.getResource("/parkHour.view.interfacciaAddetto/homeAddetto.fxml"))));
    }
}
