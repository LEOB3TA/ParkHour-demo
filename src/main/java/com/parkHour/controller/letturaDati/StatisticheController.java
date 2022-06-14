package com.parkHour.controller.letturaDati;

import com.parkHour.model.Statistiche;

public class StatisticheController implements IStatistiche {

    private Statistiche statistiche;

    public StatisticheController() {
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
