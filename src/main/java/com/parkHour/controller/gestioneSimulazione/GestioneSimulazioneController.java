package com.parkHour.controller.gestioneSimulazione;

import com.parkHour.controller.gestioneSosta.*;
import com.parkHour.model.ILetturaTarga;
import com.parkHour.model.InfoTarga;
import com.parkHour.model.LetturaTarga;
import javafx.scene.control.Alert;

import java.util.ArrayList;
import java.util.List;

public class GestioneSimulazioneController implements IGestioneSimulazioneController {
    private static final List<InfoTarga> informazioniTargheNonEntrate = new ArrayList<>();
    private static final List<InfoTarga> informazioniTargheEntrate = new ArrayList<>();
    private static IInizioSosta inizioSostaController;
    private static IFineSosta fineSostaController;
    private static ILetturaTarga letturaTarga;
    private static GestioneSimulazioneController gestioneSimulazioneController=null;

    public static GestioneSimulazioneController getInstance(){
        if (gestioneSimulazioneController == null) {
            gestioneSimulazioneController=new GestioneSimulazioneController();
        }
        return gestioneSimulazioneController;
    }


    private GestioneSimulazioneController() {
        inizioSostaController= InizioSostaController.getInstance();
        fineSostaController=FineSostaController.getInstance();
        letturaTarga = new LetturaTarga();
        InfoTarga i = new InfoTarga("AA000BB", true, false, false, 90);
        informazioniTargheNonEntrate.add(i);
        i = new InfoTarga("CC000DD", true, false, true, 90);
        informazioniTargheNonEntrate.add(i);
        i = new InfoTarga("EE00000", false, false, false, 120);
        informazioniTargheNonEntrate.add(i);
        i = new InfoTarga("GG000HH", true, true, false, 526);
        informazioniTargheNonEntrate.add(i);
        i = new InfoTarga("ZZ000SS", true, true, false, 526);
        informazioniTargheNonEntrate.add(i);
        i = new InfoTarga("II000LL", true, false, false, 430);
        informazioniTargheNonEntrate.add(i);
        i = new InfoTarga("HH00000", false, false, false, 20);
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
        letturaTarga.notificaEntrata(inizioSostaController, informazioniTargheNonEntrate.get(i));
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
        letturaTarga.notificaUscita(fineSostaController, informazioniTargheEntrate.get(i));
        informazioniTargheNonEntrate.add(informazioniTargheEntrate.get(i));
        informazioniTargheEntrate.remove(i);
    }
}
