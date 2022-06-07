package parkHour.controller.gestioneAbbonamenti;

import parkHour.model.Abbonamento;
import parkHour.model.Veicolo;

import java.util.List;

public class RimuoviAbbonamentoController implements IRimuoviAbbonamento {

    public RimuoviAbbonamentoController() {
    }

    @Override
    public boolean rimuoviAbbonamento(String targa, Abbonamento toRemove) {

        for (Veicolo a : GestioneAbbonamentiController.getVeicoli()) {
            if (a.getNumeroTarga().equals(targa)) {
                return a.rimuoviAbbonamento(toRemove);
            }
        }
        return false;
    }
}
