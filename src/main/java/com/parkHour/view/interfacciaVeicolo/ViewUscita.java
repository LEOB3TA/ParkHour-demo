package com.parkHour.view.interfacciaVeicolo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;


import java.util.Timer;
import java.util.TimerTask;

public class ViewUscita {
    @FXML
    private TextField targa;
    @FXML
    private TextField abbonamento;
    @FXML
    private TextField durataSosta;
    @FXML
    private TextField daPagare;
    @FXML
    private TextField versato;

    private float importoVersato;
    private float importoDaPagare;

    public ViewUscita() {
    }

    @FXML
    public void mostraValori(String targaV,boolean abbonamentoV,float minuti,float daPagareV){
        targa.setText(targaV);
        if(abbonamentoV){
            abbonamento.setText("Sì");
        }
        else {
            abbonamento.setText("No");
        }
        durataSosta.setText((int)minuti/60 + " ore "+ (int)minuti%60+" minuti ");
        importoDaPagare=daPagareV;
        daPagare.setText(String. format("%.2f", daPagareV)+" €");
        versato.setText("0,00 €");
        this.importoVersato=0;
    }

    @FXML
    public void versa(float daVersare) {
        if(this.importoVersato+daVersare>this.importoDaPagare){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile pagare più del dovuto");
            alert.show();
            return;
        }
        importoVersato+=daVersare;
        versato.setText(String. format("%.2f", importoVersato)+" €");
        if(importoVersato==importoDaPagare) {
            this.esci();
        }
    }

    @FXML
    public void esci(){
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Grazie di aver utilizzato il parcheggio");
        alert.show();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        targa.clear();
                        abbonamento.clear();
                        durataSosta.clear();
                        daPagare.clear();
                        versato.clear();
                        alert.close();
                    }
                });

            }
        }, 3000);
    }

}
