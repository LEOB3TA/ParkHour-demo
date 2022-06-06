package parkHour.model;

import java.time.LocalDateTime;

public class Turno {
    private final LocalDateTime dataOrarioInizio;
    private final LocalDateTime dataOrarioFine;

    public Turno(LocalDateTime dataOrarioInizio, LocalDateTime dataOrarioFine) {
        this.dataOrarioInizio = dataOrarioInizio;
        this.dataOrarioFine = dataOrarioFine;
    }

    public LocalDateTime getDataOrarioInizio() {
        return dataOrarioInizio;
    }

    public LocalDateTime getDataOrarioFine() {
        return dataOrarioFine;
    }
}