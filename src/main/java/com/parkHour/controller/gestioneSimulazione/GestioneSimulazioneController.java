package com.parkHour.controller.gestioneSimulazione;

import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneSosta.GestioneSostaController;
import com.parkHour.controller.gestioneSosta.IGestioneSosta;
import com.parkHour.model.ILetturaTarga;
import com.parkHour.model.InfoTarga;
import com.parkHour.model.LetturaTarga;
import com.parkHour.model.Sosta;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class GestioneSimulazioneController implements IGestioneSimulazioneController {
    private static List<InfoTarga> informazioniTargheNonEntrate = new ArrayList<>();
    private static List<InfoTarga> informazioniTargheEntrate = new ArrayList<>();
    private static IGestioneSosta gestioneSostaController;
    private static ILetturaTarga letturaTarga;


    public GestioneSimulazioneController() {
        gestioneSostaController = BigController.getGestioneSostaController();
        letturaTarga = new LetturaTarga();
        InfoTarga i = new InfoTarga("AA000BB", true, false, false, 90);
        informazioniTargheNonEntrate.add(i);
        i = new InfoTarga("CC000DD", true, false, true, 90);
        informazioniTargheNonEntrate.add(i);
        i = new InfoTarga("EE00000", false, false, false, 120);
        informazioniTargheNonEntrate.add(i);
        i = new InfoTarga("GG000HH", true, true, false, 526);
        informazioniTargheNonEntrate.add(i);
        i = new InfoTarga("II000LL", true, false, false, 430);
        informazioniTargheNonEntrate.add(i);
    }

    public void entrataVeicolo() {
        if(informazioniTargheNonEntrate.size()==0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("i veicoli della simulazione sono tutti all'interno");
            alert.show();
            return;
        }
        int i = (int) (Math.random() * informazioniTargheNonEntrate.size());
        letturaTarga.notificaEntrata(gestioneSostaController, informazioniTargheNonEntrate.get(i));
        informazioniTargheEntrate.add(informazioniTargheNonEntrate.get(i));
        informazioniTargheNonEntrate.remove(i);
    }

    public void uscitaVeicolo() {
        if(informazioniTargheEntrate.size()==0){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("nessun veicolo all'interno");
            alert.show();
            return;
        }
        int i = (int) (Math.random() * informazioniTargheEntrate.size());
        letturaTarga.notificaUscita(gestioneSostaController, informazioniTargheEntrate.get(i));
        informazioniTargheNonEntrate.add(informazioniTargheEntrate.get(i));
        informazioniTargheEntrate.remove(i);
    }
}
