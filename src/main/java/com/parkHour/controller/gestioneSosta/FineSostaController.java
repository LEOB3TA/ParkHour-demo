package com.parkHour.controller.gestioneSosta;

import com.parkHour.controller.BigController;
import com.parkHour.model.InfoTarga;
import com.parkHour.model.Sosta;
import javafx.application.Platform;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FineSostaController implements IFineSosta{

    private final float PREZZOSTANDARD = 1.30f;
    private final float PREZZOPREMIUM = 1.70f;
    private final float PREZZOMOTO = 1f;
    private int minuti=0;

    public FineSostaController() {
    }

    @Override
    public boolean fineSosta(InfoTarga infoTarga, LocalDateTime dataOrarioFine) {
        List<Sosta> sosteAttive=GestioneSostaController.getSosteAttive();
        Sosta sostaConlusa;
        boolean abbonamento;
        float costo;
        for(int i=0;i< sosteAttive.size();i++){
            if(sosteAttive.get(i).getVeicolo().getNumeroTarga().equals(infoTarga.getTarga())){
                sostaConlusa=sosteAttive.get(i);
                sostaConlusa.setDataOrarioFine(dataOrarioFine);
                sostaConlusa.setCosto((costo=calcolaCosto(sostaConlusa)));
                GestioneSostaController.rimuoviSostaAttiva(sostaConlusa);
                if(sostaConlusa.getVeicolo().getAbbonamenti().size()==0){
                    abbonamento=false;
                }
                else{
                    abbonamento=true;
                }
                BigController.getViewUscita().mostraValori(sostaConlusa.getVeicolo().getNumeroTarga(),abbonamento,this.minuti,costo);
                if(costo!=0) {
                   Timer timer = new Timer();
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    BigController.getViewUscita().versa(costo);
                                }
                            });
                        }
                    }, 1000);
                }else{
                    BigController.getViewUscita().esci();
                }
                return GestioneSostaController.aggiungiSostaConclusa(sostaConlusa);
            }
        }
        return false;
    }

    private float calcolaCosto(Sosta s){
        Duration durata = Duration.between(s.getDataOrarioInizio(), s.getDataOrarioFine());
        this.minuti= (int) durata.toMinutes();
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
