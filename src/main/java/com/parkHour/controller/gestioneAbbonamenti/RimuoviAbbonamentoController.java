package com.parkHour.controller.gestioneAbbonamenti;

import com.parkHour.model.Abbonamento;
import com.parkHour.model.Veicolo;

public class RimuoviAbbonamentoController implements IRimuoviAbbonamento {

    public RimuoviAbbonamentoController() {
    }

    @Override
    public boolean rimuoviAbbonamento(String targa, Abbonamento toRemove) {

        for (Veicolo a : GestioneAbbonamentiController.getVeicoli()) {
            if (a.getNumeroTarga().equals(targa)) {
                return a.rimuoviAbbonamento(toRemove);
            }
        }
        return false;
    }
}
