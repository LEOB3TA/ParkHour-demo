package com.parkHour.view.interfacciaSimulazione;

import com.parkHour.controller.gestioneSimulazione.GestioneSimulazioneController;
import com.parkHour.controller.gestioneSimulazione.IGestioneSimulazioneController;
import javafx.fxml.FXML;

public class ViewSimulazione {

    private static IGestioneSimulazioneController gestioneSimulazioneController;

    public ViewSimulazione() {
        gestioneSimulazioneController= GestioneSimulazioneController.getInstance();
    }

    @FXML
    public void onEntrataVeicoloClick(){
        gestioneSimulazioneController.entrataVeicolo();
    }

    @FXML
    public void onUscitaVeicoloClick(){
        gestioneSimulazioneController.uscitaVeicolo();
    }
}
