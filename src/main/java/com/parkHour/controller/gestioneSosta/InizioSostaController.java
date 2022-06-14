package com.parkHour.controller.gestioneSosta;

import com.parkHour.controller.BigController;
import com.parkHour.model.*;
import com.parkHour.view.interfacciaVeicolo.ViewEntrata;

import java.time.LocalDateTime;
import java.util.SortedSet;
import java.util.TreeSet;

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
       TipologiaAuto tipo;
       int posto = 0;
        if(v instanceof Moto){
            return this.minPostoCategoria(21,40);
        }
        if(v instanceof Auto){
            tipo=((Auto) v).getTipologiaAuto();
            switch (tipo){
                case PREMIUM:
                case DISABILE:
                    posto=this.minPostoCategoria(1,20);
                    break;
                case GREEN:
                    posto=this.minPostoCategoria(41,60);
                    break;
                case STANDARD:
                    posto=this.minPostoCategoria(61,200);
                    break;
            }
        }
        return posto;
    }

    private int minPostoCategoria(int min, int max){
        SortedSet<Sosta> soste = new TreeSet<Sosta>();
        int maxOccupato=min;
        for(Sosta s:GestioneSostaController.getSosteAttive()){
            if(s.getPosto()>=min && s.getPosto()<=max){
                if(maxOccupato+1<s.getPosto()){
                    return maxOccupato+1;
                } else maxOccupato=s.getPosto();
            }
        }
        return -1;
    }

}
