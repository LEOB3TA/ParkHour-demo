package com.parkHour.view.interfacciaAddetto;

import com.parkHour.ParkHourApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Objects;

public class HomeAddetto extends ViewWindowAddetto {
    @FXML
    private AnchorPane anchorPane;

    @FXML
    protected void onAggiungiAbbonamentoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane, FXMLLoader.load(Objects.requireNonNull(HomeAddetto.class.getResource("/parkHour.view.interfacciaAddetto/viewAggiungiAbb.fxml"))));
    }
    @FXML
    protected void onRimuoviAbbonamentoClick() throws IOException {
        ParkHourApplication.setRoot(anchorPane, FXMLLoader.load(Objects.requireNonNull(HomeAddetto.class.getResource("/parkHour.view.interfacciaAddetto/viewRimuoviAbb.fxml"))));
    }
}
