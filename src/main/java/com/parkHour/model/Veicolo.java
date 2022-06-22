package com.parkHour.model;

public class Veicolo {
    private final String numeroTarga;

    public Veicolo(String numeroTarga) {
        this.numeroTarga = numeroTarga;

    }

    public String getNumeroTarga() {
        return numeroTarga;
    }


    @Override
    public String toString() {
        return "Veicolo{" +
                "numeroTarga='" + numeroTarga +
                '}';
    }
}
