package com.parkHour.model;

import com.parkHour.controller.gestioneSosta.IGestioneSosta;

public class LetturaTarga implements ILetturaTarga{

    public LetturaTarga() {
    }


    @Override
    public void notificaEntrata(IGestioneSosta gestioneSosta, InfoTarga infoTarga) {
        gestioneSosta.inputEntrata(infoTarga);
    }

    @Override
    public void notificaUscita(IGestioneSosta gestioneSosta, InfoTarga infoTarga) {
        gestioneSosta.inputUscita(infoTarga);
    }
}
