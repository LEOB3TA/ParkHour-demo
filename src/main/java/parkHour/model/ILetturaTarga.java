package parkHour.model;

import parkHour.controller.gestioneSosta.IGestioneSosta;

public interface ILetturaTarga {
    public void notificaEntrata(IGestioneSosta gestioneSosta, InfoTarga infoTarga);
    public void notificaUscita(IGestioneSosta gestioneSosta,InfoTarga infoTarga);
}
