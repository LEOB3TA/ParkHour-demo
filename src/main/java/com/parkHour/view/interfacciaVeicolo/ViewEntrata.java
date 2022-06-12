package com.parkHour.view.interfacciaVeicolo;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ViewEntrata {
    @FXML
    private TextField targa;
    @FXML
    private TextField tipologia;
    @FXML
    private TextField posto;

    public ViewEntrata() {
    }

    @FXML
    public void mostraValori(String targaV,String tipologiaV,String postoV) throws InterruptedException {
        targa.setText(targaV);
        tipologia.setText(tipologiaV);
        posto.setText(postoV);
        Thread.sleep(5000);
        targa.clear();
        tipologia.clear();
        posto.clear();
    }
}
