package com.parkHour.controller.gestioneAbbonamenti;

import com.parkHour.model.Abbonamento;
import com.parkHour.model.TipologiaAbbonamento;
import com.parkHour.model.Veicolo;

import java.time.LocalDate;
import java.util.List;

public class AggiungiAbbonamentoController implements IAggiungiAbbonamento {

    public AggiungiAbbonamentoController() {
    }

    @Override
    public boolean aggiungiAbbonamento(String targa, TipologiaAbbonamento type, LocalDate dataInizio) {
        List<Veicolo> v = GestioneAbbonamentiController.getVeicoli();

        for (Veicolo vei : v
        ) {
            if (vei.getNumeroTarga().equals(targa)) {
                return vei.inserisciAbbonamento(new Abbonamento(dataInizio, type));
            } else {
                GestioneAbbonamentiController.aggiungiVeicolo(new Veicolo(targa));
                return vei.inserisciAbbonamento(new Abbonamento(dataInizio, type));
            }
        }
        return false;
    }
}

