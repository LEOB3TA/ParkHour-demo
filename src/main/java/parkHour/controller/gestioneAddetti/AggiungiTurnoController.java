package parkHour.controller.gestioneAddetti;

import parkHour.model.Addetto;

import java.time.LocalDateTime;

public class AggiungiTurnoController implements IAggiungiTurno {

    @Override
    public boolean aggiungiTurno(Addetto addetto, LocalDateTime dataOrarioInizio, LocalDateTime dataOrarioFine) {
        return false;
    }
}
