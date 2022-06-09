package com.parkHour.controller.gestioneAbbonamenti;

import com.parkHour.model.TipologiaAbbonamento;

import java.time.LocalDate;

public interface IAggiungiAbbonamento {

    boolean aggiungiAbbonamento(String targa, TipologiaAbbonamento type, LocalDate dataInizio);

}
