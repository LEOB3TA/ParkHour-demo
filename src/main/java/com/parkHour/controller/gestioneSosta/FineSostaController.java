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
    private static FineSostaController fineSostaController = null;

    public static FineSostaController getInstance() {
        if (fineSostaController == null) {
            fineSostaController = new FineSostaController();
        }
        return fineSostaController;
    }

    private FineSostaController() {
    }

    @Override
    public void fineSosta(InfoTarga infoTarga, LocalDateTime dataOrarioFine) {
        List<Sosta> sosteAttive = GestioneSostaController.getSosteAttive();
        Sosta sostaConlusa;
        boolean abbonamento=false;
        float costo;
        for (Sosta sosta : sosteAttive) {
            if (sosta.getVeicolo().getNumeroTarga().equals(infoTarga.getTarga())) {
                sostaConlusa = sosta;
                sostaConlusa.setDataOrarioFine(dataOrarioFine);
                sostaConlusa.setCosto((costo = calcolaCosto(sostaConlusa)));
                GestioneSostaController.rimuoviSostaAttiva(sostaConlusa);
                for(Abbonamento a:GestioneAbbonamentiController.getAbbonamenti()){
                    if(a.getTarga().equals(infoTarga.getTarga()) && a.isValido()){
                        abbonamento=true;
                        break;
                    }
                }
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
                GestioneSostaController.aggiungiSostaConclusa(sostaConlusa);
                return;
            }
        }
    }

    private float calcolaCosto(Sosta s) {
        int posto;
        LocalDateTime inizio = s.getDataOrarioInizio(), fine = s.getDataOrarioFine(), inizioAbb = null, fineAbb = null;
        List<Abbonamento> abbonamenti = GestioneAbbonamentiController.getAbbonamenti();
        Duration durataAbb, durata = null,duratareal;
        for (Abbonamento a : abbonamenti) {
            a.verificaValidita();
            if (a.getTarga().equals(s.getVeicolo().getNumeroTarga()) && a.isValido()) {
                inizioAbb = LocalDateTime.of(a.getDataInizio(), LocalTime.MAX);
                if (a.getTipologiaAbbonamento().equals(TipologiaAbbonamento.GIORNALIERO)) {
                    fineAbb = inizioAbb.plusDays(1);
                } else if (a.getTipologiaAbbonamento().equals(TipologiaAbbonamento.MENSILE)) {
                    fineAbb = inizioAbb.plusDays(30);
                } else fineAbb = inizioAbb.plusDays(7);
            }
        }
        if (inizioAbb != null && fineAbb!=null) {
            if (inizio.isBefore(inizioAbb) && fine.isAfter(fineAbb)) {
                durataAbb = Duration.between(inizioAbb, fineAbb);
                durata = Duration.between(s.getDataOrarioInizio(), s.getDataOrarioFine()).minus(durataAbb);
            } else if (inizio.isAfter(inizioAbb) && fine.isBefore(fineAbb)) {
                durata = Duration.between(s.getDataOrarioInizio(), s.getDataOrarioFine());
                this.minuti = (int) durata.toMinutes();
                return 0;
            } else if (inizio.isBefore(inizioAbb) && fine.isAfter(inizioAbb) && fine.isBefore(fineAbb)) {
                durataAbb = Duration.between(inizioAbb, fine);
                durata = Duration.between(s.getDataOrarioInizio(), s.getDataOrarioFine()).minus(durataAbb);
            }else if (inizio.isAfter(inizioAbb) && inizio.isBefore(fineAbb) && fine.isAfter(fineAbb)) {
                durataAbb = Duration.between(inizioAbb, fine);
                durata = Duration.between(s.getDataOrarioInizio(), s.getDataOrarioFine()).minus(durataAbb);
            }
        }
        else{
            durata = Duration.between(s.getDataOrarioInizio(), s.getDataOrarioFine());
        }
        duratareal=Duration.between(s.getDataOrarioInizio(), s.getDataOrarioFine());
        posto = s.getPosto();
        assert durata != null;
        this.minuti = (int) duratareal.toMinutes();
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
