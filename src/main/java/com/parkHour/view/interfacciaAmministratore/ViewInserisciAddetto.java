package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.ParkHourApplication;
import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ViewInserisciAddetto extends viewWindow{
    private static GestioneAddettiController gestioneAddettiController;
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
        if(gestioneAddettiController.aggiungiAddetto(nome.getText(),cognome.getText(),codFisc.getText(),username.getText(),password.getText())){
            nome.clear();cognome.clear();codFisc.clear();username.clear();password.clear();
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile inserire un nuovo addetto");
            alert.show();
        }
    }
}