package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.controller.gestioneAddetti.IGestioneAddetti;
import com.parkHour.model.Addetto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ViewAggiungiTurno extends viewWindow{
    private static IGestioneAddetti gestioneAddettiController;
    @FXML
    private ChoiceBox<Addetto> listaAddetto=new ChoiceBox<>();
    @FXML
    private DatePicker dataFine;
    @FXML
    private DatePicker dataInizio;
    @FXML
    private TextField orarioInizio;
    @FXML
    private TextField orarioFine;

    public ViewAggiungiTurno() {

        gestioneAddettiController=BigController.getGestioneAddettiController();
        ObservableList<Addetto> observableSegni= FXCollections.observableList(GestioneAddettiController.getAddetti());
        this.listaAddetto.setItems(observableSegni);
    }

    @FXML
    public void onAggiungiClick(){
        Addetto addetto=listaAddetto.getValue();
        LocalTime orarioI=LocalTime.parse(orarioInizio.getText(), DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime orarioF=LocalTime.parse(orarioFine.getText(), DateTimeFormatter.ofPattern("HH:mm"));
        LocalDateTime dataOraInizio=LocalDateTime.of(dataInizio.getValue(), orarioI);
        LocalDateTime dataOraFine=LocalDateTime.of(dataFine.getValue(), orarioF);
        if(gestioneAddettiController.aggiungiTurno(addetto,dataOraInizio,dataOraFine)){
            Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("aggiunto turno correttamente");
            alert.show();
        }
        else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile aggiungere turno");
            alert.show();
        }
    }
}
