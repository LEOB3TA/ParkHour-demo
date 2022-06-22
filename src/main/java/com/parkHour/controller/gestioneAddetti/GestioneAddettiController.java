package com.parkHour.controller.gestioneAddetti;

import com.parkHour.model.Addetto;
import com.parkHour.model.Amministratore;

import java.util.ArrayList;
import java.util.List;

public class GestioneAddettiController implements IGestioneAddetti{
    private static final Amministratore amministratore=new Amministratore("Leonardo","Focardi","FCRLD00000000","0000","admin","admin");
    private static List<Addetto>addetti;



    private static GestioneAddettiController gestioneAddettiController=null;



    private GestioneAddettiController() {
        addetti=new ArrayList<>();
        addetti.add(amministratore);
    }

    public static GestioneAddettiController getInstance(){
        if(gestioneAddettiController==null){
            gestioneAddettiController=new GestioneAddettiController();
        }
        return gestioneAddettiController;
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


    public static Amministratore getAmministratore(){
        return com.parkHour.controller.gestioneAddetti.GestioneAddettiController.amministratore;
    }

    public static List<Addetto> getAddetti() {
        return addetti;
    }


}
