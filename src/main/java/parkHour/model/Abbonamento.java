package parkHour.model;


import java.time.LocalDate;

public class Abbonamento {
    private LocalDate dataInizio;
    private TipologiaAbbonamento tipologiaAbbonamento;
    private boolean valido;

    public Abbonamento(LocalDate dataInizio, TipologiaAbbonamento tipologiaAbbonamento) {
        this.dataInizio = dataInizio;
        this.tipologiaAbbonamento = tipologiaAbbonamento;
        this.valido=true;
    }

    public LocalDate getDataInizio() {
        return dataInizio;
    }

    public TipologiaAbbonamento getTipologiaAbbonamento() {
        return tipologiaAbbonamento;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    //metodo privato per aggiornare i validi o no
}
