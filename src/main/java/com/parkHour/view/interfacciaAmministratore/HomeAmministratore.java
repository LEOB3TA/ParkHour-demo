package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.ParkHourApplication;
import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.controller.login.LoginController;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomeAmministratore extends viewWindow{

    @FXML
    private AnchorPane anchorPane;

    public HomeAmministratore() {
    }

    @FXML
    protected void onInserisciAddettoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAmministratore/viewInserisciAdd.fxml")));
    }
    @FXML
    protected void onEliminaAddettoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAmministratore/viewEliminaAdd.fxml")));
    }
    @FXML
    protected void onAggiungiTurnoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAmministratore/viewAggiungiTurno.fxml")));
    }
    @FXML
    protected void onRimuoviTurnoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAmministratore/viewRimuoviTur.fxml")));
    }
    @FXML
    protected void onMostraStatisticheClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAmministratore/viewLetturaDati.fxml")));
    }
    @FXML
    protected void onAggiungiAbbonamentoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAddetto/viewAggiungiTurno.fxml")));
    }
    @FXML
    protected void onRimuoviAbbonamentoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAddetto/viewRimuoviTur.fxml")));
    }
}
