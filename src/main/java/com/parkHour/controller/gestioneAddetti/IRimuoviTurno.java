package com.parkHour.controller.gestioneAddetti;

import com.parkHour.model.Addetto;
import com.parkHour.model.Turno;

public interface IRimuoviTurno {
     boolean rimuoviTurno(Addetto addetto,Turno toRemove);
}
