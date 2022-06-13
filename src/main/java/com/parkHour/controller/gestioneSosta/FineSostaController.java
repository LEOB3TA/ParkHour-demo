package com.parkHour.controller.gestioneSosta;

import com.parkHour.controller.BigController;
import com.parkHour.model.InfoTarga;
import com.parkHour.model.Sosta;
import javafx.application.Platform;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class FineSostaController implements IFineSosta{

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
                sostaConlusa.setCosto((costo=calcolaCosto()));
                GestioneSostaController.rimuoviSostaAttiva(sostaConlusa);
                if(sostaConlusa.getVeicolo().getAbbonamenti().size()==0){
                    abbonamento=false;
                }
                else{
                    abbonamento=true;
                }
                BigController.getViewUscita().mostraValori(sostaConlusa.getVeicolo().getNumeroTarga(),abbonamento,120,costo);
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

    private float calcolaCosto(){ //implementarlo non so se ci vanno valori in input
    return 0;
    }
}
