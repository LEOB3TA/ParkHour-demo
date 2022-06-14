package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.controller.gestioneAddetti.IGestioneAddetti;
import com.parkHour.model.Addetto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

public class ViewEliminaAddetto extends viewWindow {
    private static IGestioneAddetti gestioneAddettiController;
    @FXML
    private ComboBox<String> listaAddetti;
    @FXML
    private VBox vbox;


    public ViewEliminaAddetto() {
        gestioneAddettiController = BigController.getGestioneAddettiController();
    }


    @Override
    protected void initialize() {
        for(Addetto a:GestioneAddettiController.getAddetti()){
            listaAddetti.getItems().add(a.toString());
        }
        listaAddetti.setValue(listaAddetti.getItems().get(0));
    }

    @FXML
    protected void onEliminaClick() {
        Addetto found=null;
        for(Addetto a:GestioneAddettiController.getAddetti()) {
            if (listaAddetti.getValue().equals(a.toString())) {
                found = a;
            }
        }
       if(!gestioneAddettiController.eliminaAddetto(found)){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile eliminare l'addetto specificato");
            alert.show();
        }
    }


}
