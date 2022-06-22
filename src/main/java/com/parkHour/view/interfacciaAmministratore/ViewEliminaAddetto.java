package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.gestioneAddetti.EliminaAddettiController;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.controller.gestioneAddetti.IEliminaAddetti;
import com.parkHour.model.Addetto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.VBox;

import java.util.Objects;

public class ViewEliminaAddetto extends ViewWindow {
    private static IEliminaAddetti eliminaAddettiController;
    @FXML
    private ComboBox<String> listaAddetti;
    @FXML
    private VBox vbox;


    public ViewEliminaAddetto() {
        eliminaAddettiController = EliminaAddettiController.getInstance();
    }



    @FXML
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
                break;
            }
        }
        if(Objects.requireNonNull(found).getNumMatricola().equals("0000")){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Non puoi eliminare l'ammininstratore");
            alert.show();
        }
       if(!eliminaAddettiController.eliminaAddetto(found)){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile eliminare l'addetto specificato");
            alert.show();
        }
    }


}
