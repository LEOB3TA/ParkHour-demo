package com.parkHour.controller.gestioneSosta;

import com.parkHour.model.InfoTarga;

import java.time.LocalDateTime;

public interface IInizioSosta {
    boolean inizioSosta(InfoTarga infoTarga, LocalDateTime dataOrarioInizio);
}
