package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.controller.gestioneAddetti.IGestioneAddetti;
import com.parkHour.model.Addetto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ViewAggiungiTurno extends ViewWindow {
    private static IGestioneAddetti gestioneAddettiController;
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
        gestioneAddettiController=BigController.getGestioneAddettiController();
    }

    @Override
    protected void initialize() {
        for(Addetto a:GestioneAddettiController.getAddetti()){
            listaAddetti.getItems().add(a.toString());
        }
        listaAddetti.setValue(listaAddetti.getItems().get(0));
    }

    @FXML
    public void onAggiungiClick(){
        Alert alert;
        Addetto found=null;
        for(Addetto a:GestioneAddettiController.getAddetti()) {
            if (listaAddetti.getValue().equals(a.toString())) {
                found = a;
                break;
            }
        }
        LocalTime orarioI=LocalTime.parse(orarioInizio.getText(), DateTimeFormatter.ofPattern("HH:mm"));
        LocalTime orarioF=LocalTime.parse(orarioFine.getText(), DateTimeFormatter.ofPattern("HH:mm"));
        LocalDateTime dataOraInizio=LocalDateTime.of(dataInizio.getValue(), orarioI);
        LocalDateTime dataOraFine=LocalDateTime.of(dataFine.getValue(), orarioF);
        if(gestioneAddettiController.aggiungiTurno(found,dataOraInizio,dataOraFine)){
            alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("aggiunto turno correttamente");
            alert.show();
        }
        else{
            alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile aggiungere turno");
            alert.show();
        }
    }
}
