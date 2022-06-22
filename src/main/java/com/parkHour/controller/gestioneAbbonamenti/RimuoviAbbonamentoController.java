package com.parkHour.controller.gestioneAbbonamenti;

import com.parkHour.model.Abbonamento;

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

        for (Abbonamento a : GestioneAbbonamentiController.getAbbonamenti()) {
            if (a.getTarga().equals(toRemove.getTarga())) {
                GestioneAbbonamentiController.rimuoviAbbonamento(toRemove);
                return GestioneAbbonamentiController.rimuoviAbbonamento(a);
            }
        }
        return false;
    }
}
