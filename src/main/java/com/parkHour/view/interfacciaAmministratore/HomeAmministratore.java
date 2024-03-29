package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.ParkHourApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class HomeAmministratore extends ViewWindow {

    @FXML
    private AnchorPane anchorPane;

    public HomeAmministratore() {
    }

    @FXML
    protected void onInserisciAddettoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(Objects.requireNonNull(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAmministratore/viewInserisciAdd.fxml"))));
    }
    @FXML
    protected void onEliminaAddettoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(Objects.requireNonNull(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAmministratore/viewEliminaAdd.fxml"))));
    }
    @FXML
    protected void onAggiungiTurnoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(Objects.requireNonNull(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAmministratore/viewAggiungiTurno.fxml"))));
    }
    @FXML
    protected void onRimuoviTurnoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(Objects.requireNonNull(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAmministratore/viewRimuoviTur.fxml"))));
    }
    @FXML
    protected void onMostraStatisticheClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(Objects.requireNonNull(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAmministratore/viewLetturaDati.fxml"))));
    }
    @FXML
    protected void onAggiungiAbbonamentoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(Objects.requireNonNull(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAmministratore/viewAggiungiAbb.fxml"))));
    }
    @FXML
    protected void onRimuoviAbbonamentoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane,FXMLLoader.load(Objects.requireNonNull(HomeAmministratore.class.getResource("/parkHour.view.interfacciaAmministratore/viewRimuoviAbb.fxml"))));
    }
}
