package parkHour.model;

import java.util.List;

public class Veicolo {
    private final String numeroTarga;
    private List<Abbonamento> abbonamenti;

    public Veicolo(String numeroTarga) {
        this.numeroTarga = numeroTarga;
    }

    public String getNumeroTarga() {
        return numeroTarga;
    }

    public List<Abbonamento> getAbbonamenti() {
        return abbonamenti;
    }

    public boolean inserisciAbbonamento(Abbonamento abbonamento){
        return true;
    }

    public boolean rimuoviAbbonamento(Abbonamento abbonamento){
        return true;
    }

}
