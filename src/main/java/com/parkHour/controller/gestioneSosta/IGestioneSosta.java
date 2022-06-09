package com.parkHour.controller.gestioneSosta;

import com.parkHour.model.InfoTarga;

public interface IGestioneSosta {
    public boolean inputEntrata(InfoTarga infoTarga);
    public boolean inputUscita(InfoTarga infoTarga);
}
