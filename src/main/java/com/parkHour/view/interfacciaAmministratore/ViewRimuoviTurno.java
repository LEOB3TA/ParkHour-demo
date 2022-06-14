package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.controller.gestioneAddetti.IGestioneAddetti;
import com.parkHour.model.Addetto;
import com.parkHour.model.Turno;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;

public class ViewRimuoviTurno extends ViewWindow {
    private static IGestioneAddetti gestioneAddettiController;
    private Addetto found=null;
    @FXML
    private ChoiceBox<String> listaAddetti;
    @FXML
    private ChoiceBox<String> listaTurni;


    public ViewRimuoviTurno() {
        gestioneAddettiController= BigController.getGestioneAddettiController();
    }

    @Override
    protected void initialize() {
        for(Addetto a: GestioneAddettiController.getAddetti()){
            listaAddetti.getItems().add(a.toString());
        }
        listaAddetti.setValue(listaAddetti.getItems().get(0));
    }

    @FXML
    protected void onSelezionaAddettoClick(){
        if(listaAddetti.getValue()!=null){
            for(Addetto a:GestioneAddettiController.getAddetti()) {
                if (listaAddetti.getValue().equals(a.toString())) {
                    found = a;
                    break;
                }
            }
            for(Turno t: found.getTurni()){
                listaTurni.getItems().add(t.toString());
            }
            listaTurni.setValue(listaTurni.getItems().get(0));
        }
    }

    @FXML
    protected void onRimuoviClick(){
        Turno foundT=null;
        Alert alert;
        if(found==null){
            alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Non è stato selezionato un addetto");
            alert.show();
        }
        for(Turno t: found.getTurni()){
            if(t.toString().equals(listaTurni.getValue())){
                foundT=t;
                break;
            }
        }
        if(gestioneAddettiController.rimuoviTurno(found,foundT)){
            alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Turno rimosso correttamente");
            alert.show();
        }
        else{
            alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Impossibile rimuovere turno");
            alert.show();
        }
    }
}
