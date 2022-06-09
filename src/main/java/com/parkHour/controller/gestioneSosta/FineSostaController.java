package com.parkHour.controller.gestioneSosta;

import com.parkHour.model.InfoTarga;
import com.parkHour.model.Sosta;

import java.time.LocalDateTime;
import java.util.List;

public class FineSostaController implements IFineSosta{

    public FineSostaController() {
    }

    @Override
    public boolean fineSosta(InfoTarga infoTarga, LocalDateTime dataOrarioFine) {
        List<Sosta> sosteAttive=GestioneSostaController.getSosteAttive();
        Sosta sostaConlusa;
        for(int i=0;i< sosteAttive.size();i++){
            if(sosteAttive.get(i).getVeicolo().getNumeroTarga().equals(infoTarga.getTarga())){
                sostaConlusa=sosteAttive.get(i);
                sostaConlusa.setDataOrarioFine(dataOrarioFine);
                sostaConlusa.setCosto(calcolaCosto());
                GestioneSostaController.rimuoviSostaAttiva(sostaConlusa);
                return GestioneSostaController.aggiungiSostaConclusa(sostaConlusa);
            }
        }
        return false;
    }

    private float calcolaCosto(){ //implementarlo non so se ci vanno valori in input
    return 0;
    }
}
