package com.parkHour.model;

import com.parkHour.controller.gestioneSosta.IFineSosta;
import com.parkHour.controller.gestioneSosta.IInizioSosta;

import java.time.LocalDateTime;

public class LetturaTarga implements ILetturaTarga{


    public LetturaTarga() {
    }


    @Override
    public void notificaEntrata(IInizioSosta inizioSosta, InfoTarga infoTarga) {
      inizioSosta.inizioSosta(infoTarga, LocalDateTime.now());
    }

    @Override
    public void notificaUscita(IFineSosta fineSosta, InfoTarga infoTarga) {
        fineSosta.fineSosta(infoTarga,LocalDateTime.now().plusHours(2)); //si simula la sosta di due ore
    }
}
