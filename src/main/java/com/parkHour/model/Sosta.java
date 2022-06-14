package com.parkHour.model;

import javafx.scene.control.ComboBox;

import java.time.LocalDateTime;

public class Sosta implements Comparable {
    private final int posto;
    private final LocalDateTime dataOrarioInizio;
    private LocalDateTime dataOrarioFine;
    private float costo;
    private Veicolo veicolo;

    public Sosta(LocalDateTime dataOrarioInizio,Veicolo veicolo,int posto) {
        this.dataOrarioInizio = dataOrarioInizio;
        this.veicolo=veicolo;
        this.posto=posto;
    }

    public int getPosto() {
        return posto;
    }

    public LocalDateTime getDataOrarioInizio() {
        return dataOrarioInizio;
    }

    public LocalDateTime getDataOrarioFine() {
        return dataOrarioFine;
    }

    public float getCosto() {
        return this.costo;
    }

    public void setDataOrarioFine(LocalDateTime dataOrarioFine) {
        this.dataOrarioFine = dataOrarioFine;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }
    @Override
    public String toString() {
        return "Sosta{" +
                "posto=" + posto +
                ", dataOrarioInizio=" + dataOrarioInizio +
                ", dataOrarioFine=" + dataOrarioFine +
                ", costo=" + costo +
                ", veicolo=" + veicolo.toString() +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        Sosta s=(Sosta) o;
        return this.getPosto()-s.getPosto();
    }
}
