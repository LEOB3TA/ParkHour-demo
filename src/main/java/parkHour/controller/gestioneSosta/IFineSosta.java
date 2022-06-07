package parkHour.controller.gestioneSosta;

import parkHour.model.InfoTarga;

import java.time.LocalDateTime;

public interface IFineSosta {
    public boolean fineSosta(InfoTarga infoTarga, LocalDateTime dataOrarioFine);
}
