package com.parkHour.controller.gestioneAddetti;

import com.parkHour.model.Addetto;
import com.parkHour.model.Turno;

public class RimuoviTurnoController  implements IRimuoviTurno{


    private static RimuoviTurnoController rimuoviTurnoController=null;


    private RimuoviTurnoController() {
    }


    public static RimuoviTurnoController getInstance(){
        if(rimuoviTurnoController==null){
            rimuoviTurnoController=new RimuoviTurnoController();
        }
        return rimuoviTurnoController;
    }


    @Override
    public boolean rimuoviTurno(Addetto addetto,Turno toRemove) {
        for(int i=0;i<GestioneAddettiController.getAddetti().size();i++){
            if(GestioneAddettiController.getAddetti().get(i).equals(addetto)) {
                return GestioneAddettiController.getAddetti().get(i).removeTurno(toRemove);
            }
        }
        return false;
    }
}
