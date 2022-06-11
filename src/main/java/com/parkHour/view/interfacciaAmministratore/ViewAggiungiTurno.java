package com.parkHour.view.interfacciaAmministratore;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class ViewAggiungiTurno extends viewWindow{
    @FXML
    private ChoiceBox<String> listaAddetto=new ChoiceBox<String>();

    public ViewAggiungiTurno() {
        ObservableList<String> observableSegni= FXCollections.observableArrayList("a","b","c");
        this.listaAddetto.setItems(observableSegni);
    }

    @FXML
    public void onRimuoviClick(){

    }
}
