package com.parkHour.view.interfacciaAddetto;

import com.parkHour.ParkHourApplication;
import com.parkHour.view.interfacciaAmministratore.ViewWindow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class HomeAddetto extends ViewWindowAddetto {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    protected void onAggiungiAbbonamentoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane, FXMLLoader.load(HomeAddetto.class.getResource("/parkHour.view.interfacciaAddetto/viewAggiungiAbb.fxml")));
    }
    @FXML
    protected void onRimuoviAbbonamentoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane, FXMLLoader.load(HomeAddetto.class.getResource("/parkHour.view.interfacciaAddetto/viewRimuoviAbb.fxml")));
    }
}
