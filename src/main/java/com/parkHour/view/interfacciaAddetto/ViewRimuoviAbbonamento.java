package com.parkHour.view.interfacciaAddetto;

import com.parkHour.controller.gestioneAbbonamenti.GestioneAbbonamentiController;
import com.parkHour.controller.gestioneAbbonamenti.IRimuoviAbbonamento;
import com.parkHour.controller.gestioneAbbonamenti.RimuoviAbbonamentoController;
import com.parkHour.model.Abbonamento;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;

import java.util.ArrayList;
import java.util.List;

public class ViewRimuoviAbbonamento extends ViewWindowAddetto{

    private final IRimuoviAbbonamento rimuoviAbbonamentoController;
    @FXML
    private ChoiceBox<String> listaAbbonamento;

    public ViewRimuoviAbbonamento() {
        rimuoviAbbonamentoController= RimuoviAbbonamentoController.getInstance();
    }

    @Override
    protected void initialize() {
        super.initialize();
        for(Abbonamento a:GestioneAbbonamentiController.getAbbonamenti()){
            listaAbbonamento.getItems().add(a.toString());
        }
    }

    @FXML
    protected void onRimuoviClick(){
        List<Abbonamento> temp=new ArrayList<>(GestioneAbbonamentiController.getAbbonamenti());
        for(Abbonamento a:temp){
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
