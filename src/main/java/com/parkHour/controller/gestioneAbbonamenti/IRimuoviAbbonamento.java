package com.parkHour.controller.gestioneAbbonamenti;

import com.parkHour.model.Abbonamento;

public interface IRimuoviAbbonamento {
    public boolean rimuoviAbbonamento(String targa,Abbonamento toRemove);
}
