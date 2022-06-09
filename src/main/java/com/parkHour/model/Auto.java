package com.parkHour.model;

public class Auto extends Veicolo{

    private final TipologiaAuto tipologiaAuto;
    public Auto(String numeroTarga,TipologiaAuto tipologiaAuto) {
        super(numeroTarga);
        this.tipologiaAuto=tipologiaAuto;
    }

    public TipologiaAuto getTipologiaAuto() {
        return tipologiaAuto;
    }
}
