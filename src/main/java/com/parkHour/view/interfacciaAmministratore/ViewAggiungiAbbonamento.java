package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.gestioneAbbonamenti.AggiungiAbbonamentoController;
import com.parkHour.controller.gestioneAbbonamenti.IAggiungiAbbonamento;
import com.parkHour.model.TipologiaAbbonamento;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class ViewAggiungiAbbonamento extends ViewWindow {
    private final IAggiungiAbbonamento aggiungiAbbonamentoController;
    private final ToggleGroup group = new ToggleGroup();

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

    @Override
    protected void initialize() {
        super.initialize();
        giornaliero.setToggleGroup(group);
        settimanale.setToggleGroup(group);
        mensile.setToggleGroup(group);
    }

    @FXML
    protected void onAggiungiClick(){
        Alert alert;
        TipologiaAbbonamento tipologiaAbbonamento = null;
        if(numTarga.getText().length()!=7){
            alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("La targa deve essere esattamente di 7 caratteri");
            alert.show();
            return;
        }
        for(int i=0;i<numTarga.getText().length();i++){
            char c=numTarga.getCharacters().charAt(i);
            if(i<2 || i>4){
                if(!Character.isUpperCase(c)){
                    alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Formato targa errato");
                    alert.show();
                    return;
                }
            }
            else if(i>1 && i<5){
                if(!Character.isDigit(c)){
                    alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("Formato targa errato");
                    alert.show();
                    return;
                }
            }
        }

        if(giornaliero.isSelected()){
            tipologiaAbbonamento=TipologiaAbbonamento.GIORNALIERO;
        }
        else if(mensile.isSelected()){
            tipologiaAbbonamento=TipologiaAbbonamento.MENSILE;
        }
        else if(settimanale.isSelected()){
            tipologiaAbbonamento=TipologiaAbbonamento.ANNUALE;
        }
        if(!aggiungiAbbonamentoController.aggiungiAbbonamento(numTarga.getText(),tipologiaAbbonamento,dataInizio.getValue())){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile inserire un nuovo abbonemento");
            alert.show();
        }else {
            alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Abbonamento inserito correttamente");
            alert.show();
            numTarga.clear();
            giornaliero.setSelected(false);
            settimanale.setSelected(false);
            mensile.setSelected(false);
        }

    }

}
