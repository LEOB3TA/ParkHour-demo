package com.parkHour.controller.gestioneAddetti;

import com.parkHour.model.Addetto;

public class EliminaAddettiController  implements IEliminaAddetti{

    private static EliminaAddettiController eliminaAddettiController =null;


    private EliminaAddettiController() {
    }

    public static EliminaAddettiController getInstance(){
        if(eliminaAddettiController ==null){
            eliminaAddettiController =new EliminaAddettiController();
        }
        return eliminaAddettiController;
    }


    @Override
    public boolean eliminaAddetto(Addetto toDelete) {
        return GestioneAddettiController.rimuoviAddetto(toDelete);
    }
}
