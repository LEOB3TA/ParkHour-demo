package com.parkHour.model;


import java.time.LocalDate;

public class Abbonamento {
    private final String targa;
    private final LocalDate dataInizio;
    private final TipologiaAbbonamento tipologiaAbbonamento;
    private boolean valido;

    public Abbonamento(String targa,LocalDate dataInizio, TipologiaAbbonamento tipologiaAbbonamento) {
        this.targa = targa;
        this.dataInizio = dataInizio;
        this.tipologiaAbbonamento = tipologiaAbbonamento;
        this.valido=true;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public TipologiaAbbonamento getTipologiaAbbonamento() {
        return tipologiaAbbonamento;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    @Override
    public String toString() {
        return "Abbonamento{" +
                "targa='" + targa + '\'' +
                ", dataInizio=" + dataInizio +
                ", tipologiaAbbonamento=" + tipologiaAbbonamento +
                ", valido=" + valido +
                '}';
    }

    private void verificaValidita(){
        switch (this.tipologiaAbbonamento){
            case ANNUALE:
                if(this.dataInizio.plusYears(1).compareTo(LocalDate.now())>0){
                    this.setValido(false);
                }
                break;
            case MENSILE:
                if(this.dataInizio.plusMonths(1).compareTo(LocalDate.now())>0){
                    this.setValido(false);
                }
                break;
            case GIORNALIERO:
                if(this.dataInizio.plusDays(1).compareTo(LocalDate.now())>0){
                    this.setValido(false);
                }
                break;
        }
    }

    public String getTarga() {
        return targa;
    }

}
