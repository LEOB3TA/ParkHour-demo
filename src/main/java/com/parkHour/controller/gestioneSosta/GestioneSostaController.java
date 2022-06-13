package com.parkHour.controller.gestioneSosta;

import com.parkHour.model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestioneSostaController implements IGestioneSosta{
    private static List<Sosta> sosteAttive=new ArrayList<>();
    private static List<Sosta> sosteConcluse=new ArrayList<>(); //simuliamo il db, non carichiamo nulla sul db ma su soste concluse
    private static IInizioSosta inizioSostaController;
    private static IFineSosta fineSostaController;




    public GestioneSostaController() {
        inizioSostaController = new InizioSostaController();
        fineSostaController = new FineSostaController();
    }

    @Override
    public boolean inputEntrata(InfoTarga infoTarga) {
       return inizioSostaController.InizioSosta(infoTarga,LocalDateTime.now());
    }

    @Override
    public boolean inputUscita(InfoTarga infoTarga) {
        return fineSostaController.fineSosta(infoTarga,LocalDateTime.now());
    }

    public static boolean aggiungiSostaAttiva(Sosta s){
       return sosteAttive.add(s);
    }

    public static boolean rimuoviSostaAttiva(Sosta s){
        return sosteAttive.remove(s);
    }

    public static boolean aggiungiSostaConclusa(Sosta s){
        return sosteConcluse.add(s);
    }

    public static boolean rimuoviSostaConclusa(Sosta s){
        return sosteConcluse.remove(s);
    }

    public static List<Sosta> getSosteAttive() {
        return sosteAttive;
    }

    public static List<Sosta>getSosteConcluse(){return sosteConcluse;}
}
