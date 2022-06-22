package com.parkHour.controller.gestioneSosta;

import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneAbbonamenti.GestioneAbbonamentiController;
import com.parkHour.model.Abbonamento;
import com.parkHour.model.InfoTarga;
import com.parkHour.model.Sosta;
import com.parkHour.model.TipologiaAbbonamento;
import javafx.application.Platform;


import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FineSostaController implements IFineSosta {

    private int minuti = 0;
    private static FineSostaController fineSostaController=null;

    public static FineSostaController getInstance(){
        if (fineSostaController == null) {
            fineSostaController=new FineSostaController();
        }
        return fineSostaController;
    }

    private FineSostaController() {
    }

    @Override
    public boolean fineSosta(InfoTarga infoTarga, LocalDateTime dataOrarioFine) {
        List<Sosta> sosteAttive = GestioneSostaController.getSosteAttive();
        Sosta sostaConlusa;
        boolean abbonamento;
        float costo;
        for (Sosta sosta : sosteAttive) {
            if (sosta.getVeicolo().getNumeroTarga().equals(infoTarga.getTarga())) {
                sostaConlusa = sosta;
                sostaConlusa.setDataOrarioFine(dataOrarioFine);
                sostaConlusa.setCosto((costo = calcolaCosto(sostaConlusa)));
                GestioneSostaController.rimuoviSostaAttiva(sostaConlusa);
                abbonamento = sostaConlusa.getVeicolo().getAbbonamenti().size() != 0; //sbagliata
                BigController.getViewUscita().mostraValori(sostaConlusa.getVeicolo().getNumeroTarga(), abbonamento, this.minuti, costo);
                if (costo != 0) {
                    Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Platform.runLater(() -> BigController.getViewUscita().versa(costo));
                        }
                    }, 1000);
                } else {
                    BigController.getViewUscita().esci();
                }
                return GestioneSostaController.aggiungiSostaConclusa(sostaConlusa);
            }
        }
        return false;
    }

    private float calcolaCosto(Sosta s) {
        Duration dutaraAbbonamenti=Duration.ZERO;
        LocalDateTime inizio=s.getDataOrarioInizio(), fine=s.getDataOrarioFine(), inizioAbb, fineAbb;
        List<Abbonamento> abbonamenti = GestioneAbbonamentiController.getAbbonamenti();
        for(Abbonamento a:abbonamenti){
            if(a.getTarga().equals(s.getVeicolo().getNumeroTarga())) {
                inizioAbb = LocalDateTime.of(a.getDataInizio(), LocalTime.MIN);
                if (a.getTipologiaAbbonamento().equals(TipologiaAbbonamento.GIORNALIERO)) {
                    fineAbb = inizioAbb.plusDays(1);
                } else if (a.getTipologiaAbbonamento().equals(TipologiaAbbonamento.MENSILE)) {
                    fineAbb = inizioAbb.plusDays(30);
                } else fineAbb = inizioAbb.plusDays(365);
                if (inizioAbb.isAfter(inizio) && fineAbb.isBefore(fine)) {
                    if (a.getTipologiaAbbonamento().equals(TipologiaAbbonamento.GIORNALIERO)) {
                        dutaraAbbonamenti.plusDays(1);
                    } else if (a.getTipologiaAbbonamento().equals(TipologiaAbbonamento.MENSILE)) {
                        dutaraAbbonamenti.plusDays(30);
                    } else dutaraAbbonamenti.plusDays(365);
                }
            }
        }
        Duration durata = Duration.between(s.getDataOrarioInizio(), s.getDataOrarioFine()).minus(dutaraAbbonamenti);
        this.minuti = (int) durata.toMinutes();
        int posto = s.getPosto();
        if (posto <= 20) {
            float PREZZOPREMIUM = 1.70f;
            return Math.floorDiv(durata.toMinutes(), 60) * PREZZOPREMIUM;
        } else if (posto <= 40) {
            float PREZZOMOTO = 1f;
            return Math.floorDiv(durata.toMinutes(), 60) * PREZZOMOTO;
        } else {
            float PREZZOSTANDARD = 1.30f;
            return Math.floorDiv(durata.toMinutes(), 60) * PREZZOSTANDARD;
        }
    }
}
