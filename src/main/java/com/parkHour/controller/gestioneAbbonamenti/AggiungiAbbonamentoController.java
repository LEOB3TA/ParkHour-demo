package com.parkHour.controller.gestioneAbbonamenti;

import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
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



    //questo è sbagliato da riprendere da quello salvato su windows accidenta a me e a quando non ho fatto la commit
    @Override
    public boolean aggiungiAbbonamento(String targa, TipologiaAbbonamento type, LocalDate dataInizio) {
        List<Veicolo> v = GestioneAbbonamentiController.getVeicoli();

        for (Veicolo vei : v) {
            if (vei.getNumeroTarga().equals(targa)) {
                return vei.inserisciAbbonamento(new Abbonamento(dataInizio, type));
            }
        }
        Veicolo veicolo;
        GestioneAbbonamentiController.aggiungiVeicolo((veicolo=new Veicolo(targa)));
        return GestioneAbbonamentiController.getVeicoli().get(GestioneAbbonamentiController.getVeicoli().size()-1).inserisciAbbonamento(new Abbonamento(dataInizio,type));
    }
}

