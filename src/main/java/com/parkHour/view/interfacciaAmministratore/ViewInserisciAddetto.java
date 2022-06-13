package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.ParkHourApplication;
import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.controller.gestioneAddetti.IGestioneAddetti;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ViewInserisciAddetto extends viewWindow{
    private static IGestioneAddetti gestioneAddettiController;
    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private TextField codFisc;
    @FXML
    private TextField username;
    @FXML
    private TextField password;





    public ViewInserisciAddetto() {
        gestioneAddettiController= BigController.getGestioneAddettiController();
    }

    @FXML
    protected void onAggiungiClick(){

        if(nome.getText().isEmpty()|| cognome.getText().isEmpty() || codFisc.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("nessun campo può essere vuoto");
            alert.show();
        }
        if(nome.getText().length()>20){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Nome troppo lungo, deve essere inferiore a 20 caratteri");
            alert.show();
        }
        if(cognome.getText().length()>20){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Cognome troppo lungo, deve essere inferiore a 20 caratteri");
            alert.show();
        }
        if(codFisc.getText().length()!=16){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("formato codice fiscale errato, deve essere di 16 caratteri");
            alert.show();
        }
        if(username.getText().length()>20){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username troppo lungo, deve essere inferiore a 20 caratteri");
            alert.show();
        }

        if(gestioneAddettiController.aggiungiAddetto(nome.getText(),cognome.getText(),codFisc.getText(),username.getText(),password.getText())){
            nome.clear();cognome.clear();codFisc.clear();username.clear();password.clear();
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile inserire un nuovo addetto");
            alert.show();
        }
    }
}
