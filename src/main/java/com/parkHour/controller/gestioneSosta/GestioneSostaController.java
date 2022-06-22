package com.parkHour.controller.gestioneSosta;

import com.parkHour.model.*;

import java.util.ArrayList;
import java.util.List;

public class GestioneSostaController implements IGestioneSosta{
    private static final List<Sosta> sosteAttive=new ArrayList<>();
    private static final List<Sosta> sosteConcluse=new ArrayList<>(); //simuliamo il db, non carichiamo nulla sul db ma su soste concluse

    private GestioneSostaController() {
    }

    public static boolean aggiungiSostaAttiva(Sosta s){
       return sosteAttive.add(s);
    }

    public static void rimuoviSostaAttiva(Sosta s){
        sosteAttive.remove(s);
    }

    public static boolean aggiungiSostaConclusa(Sosta s){
        return sosteConcluse.add(s);
    }

    public static List<Sosta> getSosteAttive() {
        return sosteAttive;
    }

}
