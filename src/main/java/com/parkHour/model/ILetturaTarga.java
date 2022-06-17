package com.parkHour.model;

import com.parkHour.controller.gestioneSosta.IFineSosta;
import com.parkHour.controller.gestioneSosta.IInizioSosta;

public interface ILetturaTarga {
    void notificaEntrata(IInizioSosta inizioSosta, InfoTarga infoTarga);
    void notificaUscita(IFineSosta fineSosta, InfoTarga infoTarga);
}
