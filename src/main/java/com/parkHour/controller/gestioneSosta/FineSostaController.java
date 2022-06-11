package com.parkHour.controller.gestioneSosta;

import com.parkHour.model.InfoTarga;
import com.parkHour.model.Sosta;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class FineSostaController implements IFineSosta {
    private final float PREZZOSTANDARD = 1.30f;
    private final float PREZZOPREMIUM = 1.70f;
    private final float PREZZOMOTO = 1f;

    public FineSostaController() {
    }

    @Override
    public boolean fineSosta(InfoTarga infoTarga, LocalDateTime dataOrarioFine) {
        List<Sosta> sosteAttive = GestioneSostaController.getSosteAttive();
        Sosta sostaConlusa;
        for (Sosta s : sosteAttive) {
            if (s.getVeicolo().getNumeroTarga().equals(infoTarga.getTarga())) {
                sostaConlusa = s;
                sostaConlusa.setDataOrarioFine(dataOrarioFine);
                sostaConlusa.setCosto(calcolaCosto(s));
                GestioneSostaController.rimuoviSostaAttiva(sostaConlusa);
                return GestioneSostaController.aggiungiSostaConclusa(sostaConlusa);
            }
        }
        return false;
    }

    private float calcolaCosto(Sosta s) { //implementarlo non so se ci vanno valori in input
        Duration durata = Duration.between(s.getDataOrarioInizio(), s.getDataOrarioFine());
        int posto = s.getPosto();
        if (posto <= 20) {
            return Math.floorDiv(durata.toMinutes(), 60) * this.PREZZOPREMIUM;
        } else if (posto <= 40) {
            return Math.floorDiv(durata.toMinutes(), 60) * this.PREZZOMOTO;
        } else {
            return Math.floorDiv(durata.toMinutes(), 60) * this.PREZZOSTANDARD;
        }
    }
}
