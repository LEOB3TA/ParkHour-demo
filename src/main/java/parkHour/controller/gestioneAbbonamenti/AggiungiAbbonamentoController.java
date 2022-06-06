package parkHour.controller.gestioneAbbonamenti;

import parkHour.model.TipologiaAbbonamento;

import java.time.LocalDate;

public class AggiungiAbbonamentoController implements IAggiungiAbbonamento{
    @Override
    public boolean aggiungiAbbonamento(String targa, TipologiaAbbonamento tipologiaAbbonamento, LocalDate dataInizio) {
        return false;
    }
}
