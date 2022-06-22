package com.parkHour.controller.gestioneSosta;

import com.parkHour.model.InfoTarga;

import java.time.LocalDateTime;

public interface IFineSosta {
    void fineSosta(InfoTarga infoTarga, LocalDateTime dataOrarioFine);
}
