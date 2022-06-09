package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.model.Addetto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableListBase;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;

public class ViewEliminaAddetto extends viewWindow{
    private static GestioneAddettiController gestioneAddettiController;
    private ObservableList<Addetto> adde;
    @FXML
    private ChoiceBox<Addetto> addetti=new ChoiceBox<>();

    public ViewEliminaAddetto() {
        gestioneAddettiController= BigController.getGestioneAddettiController();
        adde= FXCollections.observableList(GestioneAddettiController.getAddetti());
        System.out.println(adde.get(0).toString());
        addetti.setItems(adde);
    }

    @FXML
    protected void onEliminaClick(){
        if(!gestioneAddettiController.eliminaAddetto((Addetto) addetti.getValue())){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile eliminare l'addetto specificato");
            alert.show();
        }
    }


}
