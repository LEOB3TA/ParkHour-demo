package parkHour.controller.gestioneSosta;

import parkHour.model.InfoTarga;

public interface IGestioneSosta {
    public boolean inputEntrata(InfoTarga infoTarga);
    public boolean inputUscita(InfoTarga infoTarga);
}
