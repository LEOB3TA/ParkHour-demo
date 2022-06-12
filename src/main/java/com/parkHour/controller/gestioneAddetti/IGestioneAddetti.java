package com.parkHour.controller.gestioneAddetti;

import com.parkHour.model.Addetto;
import com.parkHour.model.Amministratore;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public interface IGestioneAddetti {
    Amministratore amministratore=new Amministratore("Leonardo","Focardi","FCRLD00000000","0000","leob3ta","1234");
    List<Addetto>addetti=new ArrayList<>();
    boolean aggiungiTurno(Addetto addetto, LocalDateTime dataOraInizio, LocalDateTime dataOraFine);

    boolean aggiungiAddetto(String text, String text1, String text2, String text3, String text4);
}
