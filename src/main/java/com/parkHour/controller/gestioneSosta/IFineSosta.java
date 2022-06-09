package com.parkHour.controller.gestioneSosta;

import com.parkHour.model.InfoTarga;

import java.time.LocalDateTime;

public interface IFineSosta {
    public boolean fineSosta(InfoTarga infoTarga, LocalDateTime dataOrarioFine);
}
