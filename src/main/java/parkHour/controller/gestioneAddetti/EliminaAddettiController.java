package parkHour.controller.gestioneAddetti;

import parkHour.model.Addetto;

public class EliminaAddettiController  implements IEliminaAddetti{
    @Override
    public boolean eliminaAddetto(Addetto toDelete) {
        return GestioneAddettiController.rimuoviAddetto(toDelete);
    }
}