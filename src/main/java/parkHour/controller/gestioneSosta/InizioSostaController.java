package parkHour.controller.gestioneSosta;

import parkHour.model.*;

import java.time.LocalDateTime;

public class InizioSostaController implements IInizioSosta{

    public InizioSostaController() {
    }

    @Override
    public boolean InizioSosta(InfoTarga infoTarga, LocalDateTime dataOrarioInizio) {
        Sosta sosta;
        if(infoTarga.isAuto()){
            Auto auto;
            if(infoTarga.getCavalli()>250) {
                auto = new Auto(infoTarga.getTarga(), TipologiaAuto.PREMIUM);
            }
            else if(infoTarga.isDisabile()){
                auto = new Auto(infoTarga.getTarga(), TipologiaAuto.DISABILE);
            }
            else if(infoTarga.isGreen()){
                auto = new Auto(infoTarga.getTarga(), TipologiaAuto.GREEN);
            }
            else{
                auto=new Auto(infoTarga.getTarga(), TipologiaAuto.STANDARD);
            }
            sosta=new Sosta(dataOrarioInizio,auto,this.calcoloPosto(auto));
        }
        else {
            Moto moto=new Moto(infoTarga.getTarga());
            sosta=new Sosta(dataOrarioInizio,moto,this.calcoloPosto(moto));
        }
        return GestioneSostaController.aggiungiSostaAttiva(sosta);
    }

    private int calcoloPosto(Veicolo v){ //implementarlo per i vari tipi di parcheggio, attenzione deve essere un numero progressivo
        return 0;
    }

}
