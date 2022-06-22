package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.gestioneAddetti.AggiungiTurnoController;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.controller.gestioneAddetti.IAggiungiTurno;
import com.parkHour.model.Addetto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class ViewAggiungiTurno extends ViewWindow {
    private static IAggiungiTurno aggiungiTurnoController;
    @FXML
    private ChoiceBox<String> listaAddetti;
    @FXML
    private DatePicker dataFine;
    @FXML
    private DatePicker dataInizio;
    @FXML
    private TextField orarioInizio;
    @FXML
    private TextField orarioFine;

    public ViewAggiungiTurno() {
        aggiungiTurnoController = AggiungiTurnoController.getInstance();
    }


    protected void initialize() {
        for (Addetto a : GestioneAddettiController.getAddetti()) {
            listaAddetti.getItems().add(a.toString());
        }
        listaAddetti.setValue(listaAddetti.getItems().get(0));
    }

    @FXML
    public void onAggiungiClick() {
        Alert alert;
        Addetto found = null;
        for (Addetto a : GestioneAddettiController.getAddetti()) {
            if (listaAddetti.getValue().equals(a.toString())) {
                found = a;
                break;
            }
        }

        try {
            LocalTime orarioI=LocalTime.parse(orarioInizio.getText(), DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime orarioF=LocalTime.parse(orarioFine.getText(), DateTimeFormatter.ofPattern("HH:mm"));
            LocalDateTime dataOraInizio=LocalDateTime.of(dataInizio.getValue(), orarioI);
            LocalDateTime dataOraFine=LocalDateTime.of(dataFine.getValue(), orarioF);

            if(dataOraFine.isBefore(dataOraInizio)){
                alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("La data di fine deve essere successiva alla data di inizio");
                alert.show();
                return;
            }

            if(!dataOraFine.minusHours(8).equals(dataOraInizio)){
                alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Il turno deve essere di 8 ore");
                alert.show();
                return;
            }

            if(aggiungiTurnoController.aggiungiTurno(found,dataOraInizio,dataOraFine)){
                 alert=new Alert(Alert.AlertType.CONFIRMATION);
                alert.setContentText("aggiunto turno correttamente");
                alert.show();
            }
            else{
                 alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("impossibile aggiungere turno");
                alert.show();
            }
        } catch (DateTimeParseException e){
             alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Formato orario sabgliato, deve essere HH:mm");
            alert.show();
        }
    }
}
