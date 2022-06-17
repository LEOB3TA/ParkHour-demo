package com.parkHour.controller.gestioneAbbonamenti;

import com.parkHour.model.Abbonamento;
import com.parkHour.model.TipologiaAbbonamento;
import com.parkHour.model.Veicolo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface IGestioneAbbonamenti {
    boolean aggiungiAbbonamento(String targa, TipologiaAbbonamento type, LocalDate data);
    boolean eliminaAbbonamento(String targa,Abbonamento toRemove);
}
