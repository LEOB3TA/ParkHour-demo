package com.parkHour.model;

public class InfoTarga {
    private final String targa;
    private final boolean isAuto;
    private final boolean isDisabile;
    private final boolean isGreen;
    private final int cavalli;

    public InfoTarga(String targa, boolean isAuto, boolean isDisabile, boolean isGreen, int cavalli) {
        this.targa = targa;
        this.isAuto = isAuto;
        this.isDisabile = isDisabile;
        this.isGreen = isGreen;
        this.cavalli = cavalli;
    }

    public String getTarga() {
        return targa;
    }

    public boolean isAuto() {
        return isAuto;
    }

    public boolean isDisabile() {
        return isDisabile;
    }

    public boolean isGreen() {
        return isGreen;
    }

    public int getCavalli() {
        return cavalli;
    }
}
