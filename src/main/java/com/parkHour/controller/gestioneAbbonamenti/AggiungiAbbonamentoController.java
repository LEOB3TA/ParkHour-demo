package com.parkHour.controller.gestioneAbbonamenti;

import com.parkHour.model.Abbonamento;
import com.parkHour.model.TipologiaAbbonamento;


import java.time.LocalDate;


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
        Abbonamento a=new Abbonamento(targa,dataInizio, type);
        return !GestioneAbbonamentiController.aggiungiAbbonamento(a);
    }
}

