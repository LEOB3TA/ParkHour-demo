package parkHour.controller.gestioneAbbonamenti;

import parkHour.model.Abbonamento;
import parkHour.model.TipologiaAbbonamento;
import parkHour.model.Veicolo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AggiungiAbbonamentoController implements IAggiungiAbbonamento {

    public AggiungiAbbonamentoController() {
    }

    @Override
    public boolean aggiungiAbbonamento(String targa, TipologiaAbbonamento type, LocalDate dataInizio) {
        List<Veicolo> v = GestioneAbbonamentiController.getVeicoli();

        for (Veicolo vei : v
        ) {
            if (vei.getNumeroTarga().equals(targa)) {
                return vei.inserisciAbbonamento(new Abbonamento(dataInizio, type));
            } else {
                GestioneAbbonamentiController.aggiungiVeicolo(new Veicolo(targa));
                return vei.inserisciAbbonamento(new Abbonamento(dataInizio, type));
            }
        }
        return false;
    }
}

