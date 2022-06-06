package parkHour.controller.gestioneAbbonamenti;

import parkHour.model.TipologiaAbbonamento;

import java.time.LocalDate;

public interface IAggiungiAbbonamento {
    public boolean aggiungiAbbonamento(String targa, TipologiaAbbonamento tipologiaAbbonamento, LocalDate dataInizio);
}
