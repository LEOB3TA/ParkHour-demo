package parkHour.controller.gestioneAddetti;

import parkHour.model.Addetto;
import parkHour.model.Turno;

import java.time.LocalDateTime;

public class AggiungiTurnoController implements IAggiungiTurno {

    @Override
    public boolean aggiungiTurno(Addetto addetto, LocalDateTime dataOrarioInizio, LocalDateTime dataOrarioFine) {
        for(int i=0;i<GestioneAddettiController.getAddetti().size();i++){
            if(GestioneAddettiController.getAddetti().get(i).equals(addetto)) {
                return GestioneAddettiController.getAddetti().get(i).addTurno(new Turno(dataOrarioInizio, dataOrarioFine));
            }
        }
        return false;
    }
}
