package com.parkHour.view.interfacciaAddetto;

import com.parkHour.controller.gestioneAbbonamenti.GestioneAbbonamentiController;
import com.parkHour.controller.gestioneAbbonamenti.IRimuoviAbbonamento;
import com.parkHour.controller.gestioneAbbonamenti.RimuoviAbbonamentoController;
import com.parkHour.model.Abbonamento;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;

public class ViewRimuoviAbbonamento extends ViewWindowAddetto{

    private final IRimuoviAbbonamento rimuoviAbbonamentoController;
    @FXML
    private ChoiceBox<String> listaAbbonamento;

    public ViewRimuoviAbbonamento() {
        rimuoviAbbonamentoController= RimuoviAbbonamentoController.getInstance();
    }

    @FXML
    protected void initialize() {
        for(Abbonamento a:GestioneAbbonamentiController.getAbbonamenti()){
            listaAbbonamento.getItems().add(a.toString());
        }
        listaAbbonamento.setValue(listaAbbonamento.getItems().get(0));
    }

    @FXML
    protected void onRimuoviClick(){
        for(Abbonamento a:GestioneAbbonamentiController.getAbbonamenti()){
            if(a.toString().equals(listaAbbonamento.getValue())){
                if(rimuoviAbbonamentoController.rimuoviAbbonamento(a)){
                    Alert alert=new Alert(Alert.AlertType.INFORMATION);
                    alert.setContentText("abbonamento rimosso correttamente");
                    alert.show();
                }
                else{
                    Alert alert=new Alert(Alert.AlertType.ERROR);
                    alert.setContentText("impossibile rimuovere abbonamento");
                    alert.show();
                }
            }
        }
    }
}
