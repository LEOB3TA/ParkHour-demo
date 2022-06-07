package parkHour.controller.gestioneAddetti;

import parkHour.model.Addetto;
import parkHour.model.Turno;

public interface IRimuoviTurno {
     boolean rimuoviTurno(Addetto addetto,Turno toRemove);
}
