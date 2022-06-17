package com.parkHour.view.interfacciaAddetto;

import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneAbbonamenti.AggiungiAbbonamentoController;
import com.parkHour.controller.gestioneAbbonamenti.IAggiungiAbbonamento;
import com.parkHour.controller.gestioneAbbonamenti.IGestioneAbbonamenti;
import com.parkHour.model.TipologiaAbbonamento;
import com.parkHour.view.interfacciaAmministratore.ViewWindow;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;


public class ViewAggiungiAbbonamento extends ViewWindowAddetto {
    private IAggiungiAbbonamento aggiungiAbbonamentoController;

    @FXML
    private TextField numTarga;
    @FXML
    private RadioButton giornaliero;
    @FXML
    private RadioButton settimanale;
    @FXML
    private RadioButton mensile;
    @FXML
    private DatePicker dataInizio;

    public ViewAggiungiAbbonamento() {
       aggiungiAbbonamentoController= AggiungiAbbonamentoController.getInstance();
    }

    @FXML
    protected void onAggiungiClick(){
        TipologiaAbbonamento tipologiaAbbonamento = null;
        if(giornaliero.isArmed()){
            tipologiaAbbonamento=TipologiaAbbonamento.GIORNALIERO;
        }
        else if(mensile.isArmed()){
            tipologiaAbbonamento=TipologiaAbbonamento.MENSILE;
        }
        else if(settimanale.isArmed()){
            tipologiaAbbonamento=TipologiaAbbonamento.ANNUALE;
        }
        if(!aggiungiAbbonamentoController.aggiungiAbbonamento(numTarga.getText(),tipologiaAbbonamento,dataInizio.getValue())){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile inserire un nuovo abbonemento");
            alert.show();
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Abbonamento inserito correttamente");
            alert.show();
        }
        //controlli da inserire con tanto di specifica sulla targa, suggerimento fare un metodo compareTo sugli abbonamenti in modo  da vedere se sono prima o dopo o sovrapposti
    }

}
