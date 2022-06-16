package com.parkHour.controller.gestioneAbbonamenti;

import com.parkHour.model.Abbonamento;
import com.parkHour.model.TipologiaAbbonamento;
import com.parkHour.model.Veicolo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestioneAbbonamentiController implements IGestioneAbbonamenti {
    private static List<Veicolo> veicoli=new ArrayList<>();
    private static List<Abbonamento> abbonamenti=new ArrayList<>();
    private IAggiungiAbbonamento aggiungiAbbonamentoController=new AggiungiAbbonamentoController();
    private IRimuoviAbbonamento  rimuoviAbbonamentoController=new RimuoviAbbonamentoController();



    public GestioneAbbonamentiController(){
    }

    public static boolean aggiungiVeicolo(Veicolo v){
        return veicoli.add(v);
    }

    public static boolean rimuoviVeicolo(Veicolo veicolo){
        return veicoli.remove(veicolo);
    }


    public static List<Veicolo> getVeicoli(){
        return veicoli;
    }

    public static boolean aggiungiAbbonamento(Abbonamento a){
       return abbonamenti.add(a);
}

    public  boolean aggiungiAbbonamento(String targa, TipologiaAbbonamento type, LocalDate data){
        return aggiungiAbbonamentoController.aggiungiAbbonamento(targa, type, data);
    }

    public static boolean rimuoviAbbonamento(Abbonamento a){
        return abbonamenti.remove(a);
    }

    public boolean eliminaAbbonamento(String targa,Abbonamento toRemove) {
        return rimuoviAbbonamentoController.rimuoviAbbonamento(targa,toRemove);
    }


    public static List<Abbonamento> getAbbonamenti() {
return abbonamenti;
    }
}
