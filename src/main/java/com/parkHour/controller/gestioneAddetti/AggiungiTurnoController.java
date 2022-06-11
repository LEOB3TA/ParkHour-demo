package com.parkHour.controller.gestioneAddetti;

import com.parkHour.model.Addetto;
import com.parkHour.model.Turno;

import java.time.LocalDateTime;

public class AggiungiTurnoController implements IAggiungiTurno {

    public AggiungiTurnoController() {
    }

    @Override
    public boolean aggiungiTurno(Addetto addetto, LocalDateTime dataOrarioInizio, LocalDateTime dataOrarioFine) {
    int i=0;
        for (Addetto a : GestioneAddettiController.getAddetti()) {
            i++;
            for (Turno t : a.getTurni()) {
                if(dataOrarioInizio.isAfter(t.getDataOrarioInizio()) && dataOrarioInizio.isBefore(t.getDataOrarioFine())
                || dataOrarioFine.isAfter(t.getDataOrarioInizio()) && dataOrarioFine.isBefore(t.getDataOrarioFine())){
                    return false;
                } else{
                   return GestioneAddettiController.getAddetti().get(i).addTurno(new Turno(dataOrarioInizio, dataOrarioFine));
                }
            }
        }
        return false;
    }
}
