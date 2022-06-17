package com.parkHour.controller.gestioneAbbonamenti;

import com.parkHour.model.Abbonamento;
import com.parkHour.model.Veicolo;

public class RimuoviAbbonamentoController implements IRimuoviAbbonamento {

    private static RimuoviAbbonamentoController aggiungiAbbonamentoController=null;


    private RimuoviAbbonamentoController() {
    }

    public static RimuoviAbbonamentoController getInstance(){
        if(aggiungiAbbonamentoController==null){
            aggiungiAbbonamentoController=new RimuoviAbbonamentoController();
        }
        return aggiungiAbbonamentoController;
    }




    @Override
    public boolean rimuoviAbbonamento(Abbonamento toRemove) {

        for (Veicolo a : GestioneAbbonamentiController.getVeicoli()) {
            if (a.getNumeroTarga().equals(toRemove.getTarga())) {
                GestioneAbbonamentiController.rimuoviAbbonamento(toRemove);
                return a.rimuoviAbbonamento(toRemove);
            }
        }
        return false;
    }
}
