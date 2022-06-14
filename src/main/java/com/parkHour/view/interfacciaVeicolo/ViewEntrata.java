package com.parkHour.view.interfacciaVeicolo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.Timer;
import java.util.TimerTask;

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
    public void mostraValori(String targaV, String tipologiaV, String postoV) {
        targa.setText(targaV);
        tipologia.setText(tipologiaV);
        posto.setText(postoV);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        targa.clear();
                        tipologia.clear();
                        posto.clear();
                    }
                });

            }
        }, 3000);
    }
}
