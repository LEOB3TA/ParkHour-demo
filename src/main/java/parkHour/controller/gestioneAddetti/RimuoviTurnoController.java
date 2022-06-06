package parkHour.controller.gestioneAddetti;

import parkHour.model.Addetto;
import parkHour.model.Turno;

public class RimuoviTurnoController  implements IRimuoviTurno{
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
