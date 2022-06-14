package com.parkHour.controller;

import com.parkHour.controller.gestioneAbbonamenti.AggiungiAbbonamentoController;
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
import com.parkHour.view.interfacciaVeicolo.ViewEntrata;
import com.parkHour.view.interfacciaVeicolo.ViewUscita;

import java.util.List;

public class BigController implements IBigController{
    private static IGestioneAddetti gestioneAddettiController= new GestioneAddettiController();
    private static ILogin loginController=new LoginController();
    private static IGestioneSosta gestioneSostaController=new GestioneSostaController();
    private static IGestioneAbbonamenti gestioneAbbonamentiController=new GestioneAbbonamentiController();
    private static IGestioneSimulazioneController gestioneSimulazioneController=new GestioneSimulazioneController();
    private static ViewEntrata viewEntrata;
    private static ViewUscita viewUscita;

    private static BigController istance=null;

    private BigController() {
    }

    public static BigController getInstance(){
        if(istance==null){
            istance=new BigController();
        }
        return istance;
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

    public static ViewEntrata getViewEntrata() {
        return viewEntrata;
    }

    public static void setViewEntrata(ViewEntrata viewEntrata) {
        BigController.viewEntrata = viewEntrata;
    }

    public static ViewUscita getViewUscita() {
        return viewUscita;
    }

    public static void setViewUscita(ViewUscita viewUscita) {
        BigController.viewUscita = viewUscita;
    }
}
