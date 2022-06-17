package com.parkHour.controller.gestioneAbbonamenti;

import com.parkHour.model.Abbonamento;
import com.parkHour.model.TipologiaAbbonamento;
import com.parkHour.model.Veicolo;

import java.time.LocalDate;
import java.util.List;

public class AggiungiAbbonamentoController implements IAggiungiAbbonamento {

    private static AggiungiAbbonamentoController aggiungiAbbonamentoController=null;


    private AggiungiAbbonamentoController() {
    }

    public static AggiungiAbbonamentoController getInstance(){
        if(aggiungiAbbonamentoController==null){
            aggiungiAbbonamentoController=new AggiungiAbbonamentoController();
        }
        return aggiungiAbbonamentoController;
    }


    @Override
    public boolean aggiungiAbbonamento(String targa, TipologiaAbbonamento type, LocalDate dataInizio) {
        boolean controllo;
        List<Veicolo> v = GestioneAbbonamentiController.getVeicoli();
        for (Veicolo vei : v) {
            if (vei.getNumeroTarga().equals(targa)) {
                Abbonamento a=new Abbonamento(vei.getNumeroTarga(),dataInizio, type);
                controllo=GestioneAbbonamentiController.aggiungiAbbonamento(a);
                controllo=vei.inserisciAbbonamento(a);
                return controllo;
            }
        }
        Veicolo veicolo;
        controllo=GestioneAbbonamentiController.aggiungiVeicolo((veicolo=new Veicolo(targa)));
        Abbonamento a=new Abbonamento(targa,dataInizio, type);
        controllo=GestioneAbbonamentiController.aggiungiAbbonamento(a);
        controllo=GestioneAbbonamentiController.getVeicoli().get(GestioneAbbonamentiController.getVeicoli().size()-1).inserisciAbbonamento(new Abbonamento(veicolo.getNumeroTarga(), dataInizio,type));
        return controllo;
    }
}

