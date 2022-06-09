package com.parkHour.controller.gestioneAddetti;

import com.parkHour.model.Addetto;

import java.time.LocalDateTime;

public interface IAggiungiTurno {
    public boolean aggiungiTurno(Addetto addetto, LocalDateTime dataOrarioInizio,LocalDateTime dataOrarioFine);
}
