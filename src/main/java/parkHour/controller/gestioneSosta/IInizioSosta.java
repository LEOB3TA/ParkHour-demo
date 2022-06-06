package parkHour.controller.gestioneSosta;

import parkHour.model.InfoTarga;

import java.time.LocalDateTime;

public interface IInizioSosta {
    public boolean InizioSosta(InfoTarga infoTarga, LocalDateTime dataOrarioInizio);
}
