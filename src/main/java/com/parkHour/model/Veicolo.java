package com.parkHour.model;

import java.util.ArrayList;
import java.util.List;

public class Veicolo {
    private final String numeroTarga;
    private List<Abbonamento> abbonamenti;

    public Veicolo(String numeroTarga) {
        this.numeroTarga = numeroTarga;
        this.abbonamenti=new ArrayList<>();
    }

    public String getNumeroTarga() {
        return numeroTarga;
    }

    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }

    public boolean inserisciAbbonamento(Abbonamento abbonamento){
        return abbonamenti.add(abbonamento);
    }

    public boolean rimuoviAbbonamento(Abbonamento abbonamento){
        return abbonamenti.add(abbonamento);
    }

}
