package com.parkHour.controller.gestioneAddetti;

import com.parkHour.model.Addetto;
import com.parkHour.model.Amministratore;
import com.parkHour.model.Turno;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface IGestioneAddetti {

    boolean aggiungiTurno(Addetto addetto, LocalDateTime dataOraInizio, LocalDateTime dataOraFine);

    boolean aggiungiAddetto(String text, String text1, String text2, String text3, String text4);

    boolean eliminaAddetto(Addetto addetto);

    boolean rimuoviTurno(Addetto found, Turno foundT);
}
