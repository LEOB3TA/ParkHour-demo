package com.parkHour.view.interfacciaSimulazione;

import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneSimulazione.IGestioneSimulazioneController;
import javafx.fxml.FXML;

public class ViewSimulazione {

    private static IGestioneSimulazioneController gestioneSimulazioneController;

    public ViewSimulazione() {
        gestioneSimulazioneController= BigController.getGestioneSimulazioneController();
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
