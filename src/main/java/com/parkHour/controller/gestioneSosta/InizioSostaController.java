package com.parkHour.controller.gestioneSosta;

import com.parkHour.controller.BigController;
import com.parkHour.model.*;
import com.parkHour.view.interfacciaVeicolo.ViewEntrata;

import java.time.LocalDateTime;

public class InizioSostaController implements IInizioSosta {

    public InizioSostaController() {
    }

    @Override
    public boolean InizioSosta(InfoTarga infoTarga, LocalDateTime dataOrarioInizio) {
        Sosta sosta;
        String tipologia;
        if (infoTarga.isAuto()) {
            Auto auto;
            if (infoTarga.getCavalli() > 250) {
                auto = new Auto(infoTarga.getTarga(), TipologiaAuto.PREMIUM);
                tipologia = new String("Auto Premium");
            } else if (infoTarga.isDisabile()) {
                auto = new Auto(infoTarga.getTarga(), TipologiaAuto.DISABILE);
                tipologia = new String("Auto disabile");
            } else if (infoTarga.isGreen()) {
                auto = new Auto(infoTarga.getTarga(), TipologiaAuto.GREEN);
                tipologia = new String("Auto Green");
            } else {
                auto = new Auto(infoTarga.getTarga(), TipologiaAuto.STANDARD);
                tipologia = new String("Auto Standard");
            }
            sosta = new Sosta(dataOrarioInizio, auto, this.calcoloPosto(auto));
        } else {
            Moto moto = new Moto(infoTarga.getTarga());
            sosta = new Sosta(dataOrarioInizio, moto, this.calcoloPosto(moto));
            tipologia = new String("Moto");
        }
        BigController.getViewEntrata().mostraValori(sosta.getVeicolo().getNumeroTarga(), tipologia, String.valueOf(sosta.getPosto()));
        return GestioneSostaController.aggiungiSostaAttiva(sosta);
    }

    private int calcoloPosto(Veicolo v) { //implementarlo per i vari tipi di parcheggio, attenzione deve essere un numero progressivo
        return 0;
    }

}
