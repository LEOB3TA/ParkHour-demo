package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.model.Addetto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class ViewEliminaAddetto extends viewWindow{
    private static GestioneAddettiController gestioneAddettiController;
    private ObservableList<Addetto> adde;


    @FXML
    private ComboBox listaAddetti;

    public ViewEliminaAddetto() {
        ObservableList<String> observableSegni=FXCollections.observableArrayList("a","b","c");
        listaAddetti.setItems(observableSegni);
        listaAddetti.setEditable(false);
        listaAddetti.setValue(observableSegni.get(0));
        gestioneAddettiController= BigController.getGestioneAddettiController();

      //  for(Addetto a: GestioneAddettiController.getAddetti()){

      //  }
    }

    @FXML
    protected void onEliminaClick(){
       /* if(!gestioneAddettiController.eliminaAddetto((String) listaAddetti.getValue())){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile eliminare l'addetto specificato");
            alert.show();
        }*/
    }


}
