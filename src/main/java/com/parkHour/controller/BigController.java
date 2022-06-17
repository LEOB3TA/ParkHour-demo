package com.parkHour.controller;

import com.parkHour.controller.gestioneSosta.GestioneSostaController;
import com.parkHour.controller.letturaDati.IStatistiche;
import com.parkHour.controller.letturaDati.StatisticheController;
import com.parkHour.model.Statistiche;
import com.parkHour.view.interfacciaVeicolo.ViewEntrata;
import com.parkHour.view.interfacciaVeicolo.ViewUscita;

public class BigController implements IBigController{
    private static final IStatistiche  statisticheController = StatisticheController.getInstance();
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


    public static ViewEntrata getViewEntrata() {
        return viewEntrata;
    }

    public static void setViewEntrata(ViewEntrata viewEntrata) {
        BigController.viewEntrata = viewEntrata;
    }

    public static ViewUscita getViewUscita() {
        return viewUscita;
    }

    public static IStatistiche getStatisticheController() {
        return statisticheController;
    }

    public static void setViewUscita(ViewUscita viewUscita) {
        BigController.viewUscita = viewUscita;
    }

    public static Statistiche mostraStatistiche(){
        return statisticheController.mostraStatistiche();
    }

    public static void calcolaAndSetstatistiche(){
        Statistiche statistiche=new Statistiche(GestioneSostaController.getSosteAttive(),5,1,1,1,1,1,120,3,0);
        statisticheController.setNewStatistiche(statistiche);
    }
}
