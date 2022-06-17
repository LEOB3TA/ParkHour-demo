package com.parkHour.controller.letturaDati;

import com.parkHour.model.Statistiche;

public class StatisticheController implements IStatistiche {

    private Statistiche statistiche;
    private static StatisticheController statisticheController=null;

    public static StatisticheController getInstance(){
        if (statisticheController == null) {
            statisticheController= new StatisticheController();
        }
        return statisticheController;
    }

    private StatisticheController() {
    }

    @Override
    public Statistiche mostraStatistiche() {
        return this.statistiche;
    }

    @Override
    public void setNewStatistiche(Statistiche statistiche) {
        this.statistiche=statistiche;
    }

}
