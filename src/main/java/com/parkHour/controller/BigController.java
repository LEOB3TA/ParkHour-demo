package com.parkHour.controller;

import com.parkHour.controller.gestioneAbbonamenti.GestioneAbbonamentiController;
import com.parkHour.controller.gestioneAbbonamenti.IGestioneAbbonamenti;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.controller.gestioneAddetti.IGestioneAddetti;
import com.parkHour.controller.gestioneSimulazione.GestioneSimulazioneController;
import com.parkHour.controller.gestioneSimulazione.IGestioneSimulazioneController;
import com.parkHour.controller.gestioneSosta.GestioneSostaController;
import com.parkHour.controller.gestioneSosta.IGestioneSosta;
import com.parkHour.controller.letturaDati.IStatistiche;
import com.parkHour.controller.letturaDati.StatisticheController;
import com.parkHour.model.Statistiche;
import com.parkHour.view.interfacciaVeicolo.ViewEntrata;
import com.parkHour.view.interfacciaVeicolo.ViewUscita;

public class BigController implements IBigController{
    private static IStatistiche  statisticheController;
    private static IGestioneAddetti gestioneAddettiController;
    private static IGestioneAbbonamenti gestioneAbbonamenti;
    private static IGestioneSosta gestioneSosta;
    private static IGestioneSimulazioneController gestioneSimulazioneController;
    private static ViewEntrata viewEntrata;
    private static ViewUscita viewUscita;

    private static BigController istance=null;

    private BigController() {
        gestioneSosta= GestioneSostaController.getInstance();
        statisticheController = StatisticheController.getInstance();
        gestioneAddettiController= GestioneAddettiController.getInstance();
        gestioneAbbonamenti= GestioneAbbonamentiController.getInstance();
        gestioneSimulazioneController= GestioneSimulazioneController.getInstance();


    }

    public static BigController getInstance(){
        if(istance==null){
            istance=new BigController();
        }
        return istance;
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

    public static void calcolaAndSetstatistiche(){
        Statistiche statistiche=new Statistiche(GestioneSostaController.getSosteAttive(),5,1,1,1,1,1,120,3,0);
        statisticheController.setNewStatistiche(statistiche);
    }
}
