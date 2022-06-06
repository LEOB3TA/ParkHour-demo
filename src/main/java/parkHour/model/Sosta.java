package parkHour.model;

import java.time.LocalDateTime;

public class Sosta {
    private final int posto;
    private final LocalDateTime dataOrarioInizio;
    private LocalDateTime dataOrarioFine;
    private float costo;
    private Veicolo veicolo;

    public Sosta(LocalDateTime dataOrarioInizio,Veicolo veicolo) {
        this.dataOrarioInizio = dataOrarioInizio;
        this.veicolo=veicolo;
        this.posto=0;
        //selezionare posto in modo automatico
    }

    public int getPosto() {
        return posto;
    }

    public LocalDateTime getDataOrarioInizio() {
        return dataOrarioInizio;
    }

    public LocalDateTime getDataOrarioFine() {
        return dataOrarioFine;
    }

    public float getCosto() {
        return this.costo;
    }

    public void setDataOrarioFine(LocalDateTime dataOrarioFine) {
        this.dataOrarioFine = dataOrarioFine;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

    public Veicolo getVeicolo() {
        return veicolo;
    }
}
