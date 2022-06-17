package com.parkHour.controller.gestioneAbbonamenti;

import com.parkHour.model.Abbonamento;
import com.parkHour.model.Veicolo;

import java.util.ArrayList;
import java.util.List;

public class GestioneAbbonamentiController implements IGestioneAbbonamenti {
    private static final List<Veicolo> veicoli=new ArrayList<>();
    private static final List<Abbonamento> abbonamenti=new ArrayList<>();

    private static GestioneAbbonamentiController gestioneAbbonamentiController=null;


    private GestioneAbbonamentiController() {
    }

    public static GestioneAbbonamentiController getInstance(){
        if(gestioneAbbonamentiController==null){
           gestioneAbbonamentiController=new GestioneAbbonamentiController();
        }
        return gestioneAbbonamentiController;
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

    public static boolean rimuoviAbbonamento(Abbonamento a){
        return abbonamenti.remove(a);
    }

    public static List<Abbonamento> getAbbonamenti() {
return abbonamenti;
    }
}
