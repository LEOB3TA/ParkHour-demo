package parkHour.controller.gestioneAbbonamenti;

import parkHour.model.Abbonamento;

public interface IRimuoviAbbonamento {
    public boolean rimuoviAbbonamento(String targa,Abbonamento toRemove);
}
