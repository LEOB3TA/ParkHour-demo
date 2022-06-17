package com.parkHour.controller.gestioneAddetti;

import com.parkHour.model.Addetto;

public class AggiungiAddettiController implements IAggiungiAddetti {

    private static AggiungiAddettiController aggiungiAddettiController=null;


    private AggiungiAddettiController() {
    }

    public static AggiungiAddettiController getInstance(){
        if(aggiungiAddettiController==null){
           aggiungiAddettiController=new AggiungiAddettiController();
        }
        return aggiungiAddettiController;
    }



    @Override
    public boolean inserisciAddetto(String nome, String cognome, String codFisc, String username, String password) {
        return GestioneAddettiController.aggiungiAddetto(new Addetto(nome, cognome, codFisc, calcolaNumeroMatricola(), username, password));
    }

    private String calcolaNumeroMatricola() { // da implementare non so se sta qui o nel GestioneAddettiController
        int matricolaMax = 0;
        for (Addetto a : GestioneAddettiController.getAddetti()) {
            matricolaMax = Math.max(matricolaMax, Integer.parseInt(a.getNumMatricola()));
        }
        matricolaMax++;
        if (matricolaMax < 10) {
            return "0" + "0" + "0" + matricolaMax;
        } else if (matricolaMax < 100) {
            return "0" + "0" + matricolaMax;
        } else if (matricolaMax < 1000) {
            return "0" + matricolaMax;
        } else return "" + matricolaMax;

    }
}
