package parkHour.controller.gestioneAbbonamenti;

import parkHour.model.Abbonamento;

import java.util.List;

public class RimuoviAbbonamentoController implements IRimuoviAbbonamento{

    @Override
    public boolean rimuoviAbbonamento(Abbonamento toRemove) {

        for (Abbonamento a:GestioneAbbonamentiController.getAbbonamenti()
             ) {
     if(a.equals(toRemove)){
    return GestioneAbbonamentiController.rimuoviAbbonamento(a);
}
        }

        return false;
    }
}
