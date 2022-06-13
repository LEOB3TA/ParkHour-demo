package com.parkHour.controller.gestioneSimulazione;

import com.parkHour.model.InfoTarga;

import java.util.ArrayList;
import java.util.List;

public interface IGestioneSimulazioneController {
    List<InfoTarga> informazioniTargheNonEntrate = new ArrayList<>();
    List<InfoTarga> informazioniTargheEntrate = new ArrayList<>();

    void entrataVeicolo();
    void uscitaVeicolo();

}
