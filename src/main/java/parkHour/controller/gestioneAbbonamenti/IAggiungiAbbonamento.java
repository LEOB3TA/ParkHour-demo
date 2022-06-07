package parkHour.controller.gestioneAbbonamenti;

import parkHour.model.TipologiaAbbonamento;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface IAggiungiAbbonamento {

    boolean aggiungiAbbonamento(String targa, TipologiaAbbonamento type, LocalDate dataInizio);

}
