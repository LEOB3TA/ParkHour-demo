package com.parkHour.controller.gestioneAddetti;

import com.parkHour.model.Addetto;

public class EliminaAddettiController  implements IEliminaAddetti{
    public EliminaAddettiController() {
    }

    @Override
    public boolean eliminaAddetto(Addetto toDelete) {
        return GestioneAddettiController.rimuoviAddetto(toDelete);
    }
}
