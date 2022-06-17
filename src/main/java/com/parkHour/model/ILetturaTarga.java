package com.parkHour.model;

import com.parkHour.controller.gestioneSosta.IFineSosta;
import com.parkHour.controller.gestioneSosta.IGestioneSosta;
import com.parkHour.controller.gestioneSosta.IInizioSosta;

public interface ILetturaTarga {
    public void notificaEntrata(IInizioSosta inizioSosta, InfoTarga infoTarga);
    public void notificaUscita(IFineSosta fineSosta, InfoTarga infoTarga);
}
