package com.parkHour.controller;

import com.parkHour.controller.gestioneAbbonamenti.GestioneAbbonamentiController;
import com.parkHour.controller.gestioneAbbonamenti.IGestioneAbbonamenti;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.controller.gestioneAddetti.IGestioneAddetti;
import com.parkHour.controller.gestioneSimulazione.GestioneSimulazioneController;
import com.parkHour.controller.gestioneSimulazione.IGestioneSimulazioneController;
import com.parkHour.controller.gestioneSosta.GestioneSostaController;
import com.parkHour.controller.gestioneSosta.IGestioneSosta;
import com.parkHour.controller.login.ILogin;
import com.parkHour.controller.login.LoginController;
import com.parkHour.model.Amministratore;

import java.util.List;

public class BigController implements IBigController{

    

    public BigController() {
    }

    public static GestioneAddettiController getGestioneAddettiController() {
        return (GestioneAddettiController) gestioneAddettiController;
    }

    public static LoginController getLoginController() {
        return (LoginController) loginController;
    }

    public static GestioneSostaController getGestioneSostaController() {
        return (GestioneSostaController) gestioneSostaController;
    }

    public static GestioneAbbonamentiController getGestioneAbbonamentiController() {
        return (GestioneAbbonamentiController) gestioneAbbonamentiController;
    }

    public static GestioneSimulazioneController getGestioneSimulazioneController(){
        return (GestioneSimulazioneController) gestioneSimulazioneController;
    }

}
