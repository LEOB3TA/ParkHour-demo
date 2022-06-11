package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
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
import java.time.format.DateTimeParseException;

public class ViewAggiungiTurno extends viewWindow{
    private static GestioneAddettiController gestioneAddettiController;
    @FXML
    private ChoiceBox<Addetto> listaAddetto=new ChoiceBox<Addetto>();
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




        try {
            LocalTime orarioI=LocalTime.parse(orarioInizio.getText(), DateTimeFormatter.ofPattern("HH:mm"));
            LocalTime orarioF=LocalTime.parse(orarioFine.getText(), DateTimeFormatter.ofPattern("HH:mm"));
            LocalDateTime dataOraInizio=LocalDateTime.of(dataInizio.getValue(), orarioI);
            LocalDateTime dataOraFine=LocalDateTime.of(dataFine.getValue(), orarioF);

            if(dataOraFine.isBefore(dataOraInizio)){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("La data di fine deve essere successiva alla data di inizio");
                alert.show();
            }

            if(!dataOraFine.minusHours(8).equals(dataOraInizio)){
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Il turno deve essere di 8 ore");
                alert.show();
            }

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
        } catch (DateTimeParseException e){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Formato orario sabgliato, deve essere HH:mm");
            alert.show();
        }


    }
}
