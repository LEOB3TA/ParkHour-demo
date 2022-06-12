package com.parkHour.controller.gestioneAddetti;

import com.parkHour.model.Addetto;
import com.parkHour.model.Amministratore;
import com.parkHour.model.Turno;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GestioneAddettiController implements IGestioneAddetti{

    private final IAggiungiAddetti aggiungiAddettiController;
    private final IAggiungiTurno aggiungiTurnoController;
    private final IRimuoviTurno rimuoviTurnoController;
    private final IEliminaAddetti eliminaAddettiController;


    public GestioneAddettiController() {
        this.aggiungiAddettiController=new AggiungiAddettiController();
        this.aggiungiTurnoController=new AggiungiTurnoController();
        this.rimuoviTurnoController=new RimuoviTurnoController();
        this.eliminaAddettiController=new EliminaAddettiController();
    }

    public static boolean aggiungiAddetto(Addetto a){
       for(Addetto addetto:addetti){
           if(addetto.getCodiceFiscale().equals(a.getCodiceFiscale())){
               return false;
           }
       }
       return addetti.add(a);
    }


    public static boolean rimuoviAddetto(Addetto a){
        return addetti.remove(a);
    }

    public boolean aggiungiTurno(Addetto addetto, LocalDateTime inizio,LocalDateTime fine){
        return aggiungiTurnoController.aggiungiTurno(addetto,inizio,fine);
    }
    public boolean rimuoviTurno(Addetto addetto,Turno toRemove){
        return rimuoviTurnoController.rimuoviTurno(addetto,toRemove);
    }

    public boolean aggiungiAddetto(String nome, String cognome,String codFisc,String username,String password){
        return aggiungiAddettiController.inserisciAddetto(nome,cognome,codFisc,username,password);
    }

    public boolean eliminaAddetto(Addetto toDelete){
        return eliminaAddettiController.eliminaAddetto(toDelete);
    }

    public static Amministratore getAmministratore(){
        return GestioneAddettiController.amministratore;
    }

    public static List<Addetto> getAddetti() {
        return addetti;
    }


}
