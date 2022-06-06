package parkHour.model;

import java.util.List;

public class Statistiche {
    private List<Sosta> sosteAttive;
    private int totVeicoli;
    private int numeroStandard;
    private int numeroPremium;
    private int numeroGreen;
    private int numeroMoto;
    private int numeroDisabili;
    private float tempoDiPermanenzaMedio;
    private float costoMedio;
    private int numeroDiAbbonati;

    public Statistiche(List<Sosta> sosteAttive, int totVeicoli, int numeroStandard, int numeroPremium, int numeroGreen, int numeroMoto, int numeroDisabili, float tempoDiPermanenzaMedio, float costoMedio, int numeroDiAbbonati) {
        this.sosteAttive = sosteAttive;
        this.totVeicoli = totVeicoli;
        this.numeroStandard = numeroStandard;
        this.numeroPremium = numeroPremium;
        this.numeroGreen = numeroGreen;
        this.numeroMoto = numeroMoto;
        this.numeroDisabili = numeroDisabili;
        this.tempoDiPermanenzaMedio = tempoDiPermanenzaMedio;
        this.costoMedio = costoMedio;
        this.numeroDiAbbonati = numeroDiAbbonati;
    }

    public List<Sosta> getSosteAttive() {
        return sosteAttive;
    }

    public int getTotVeicoli() {
        return totVeicoli;
    }

    public int getNumeroStandard() {
        return numeroStandard;
    }

    public int getNumeroPremium() {
        return numeroPremium;
    }

    public int getNumeroGreen() {
        return numeroGreen;
    }

    public int getNumeroMoto() {
        return numeroMoto;
    }

    public int getNumeroDisabili() {
        return numeroDisabili;
    }

    public float getTempoDiPermanenzaMedio() {
        return tempoDiPermanenzaMedio;
    }

    public float getCostoMedio() {
        return costoMedio;
    }

    public int getNumeroDiAbbonati() {
        return numeroDiAbbonati;
    }

    public void setSosteAttive(List<Sosta> sosteAttive) {
        this.sosteAttive = sosteAttive;
    }

    public void setTotVeicoli(int totVeicoli) {
        this.totVeicoli = totVeicoli;
    }

    public void setNumeroStandard(int numeroStandard) {
        this.numeroStandard = numeroStandard;
    }

    public void setNumeroPremium(int numeroPremium) {
        this.numeroPremium = numeroPremium;
    }

    public void setNumeroGreen(int numeroGreen) {
        this.numeroGreen = numeroGreen;
    }

    public void setNumeroMoto(int numeroMoto) {
        this.numeroMoto = numeroMoto;
    }

    public void setNumeroDisabili(int numeroDisabili) {
        this.numeroDisabili = numeroDisabili;
    }

    public void setTempoDiPermanenzaMedio(float tempoDiPermanenzaMedio) {
        this.tempoDiPermanenzaMedio = tempoDiPermanenzaMedio;
    }

    public void setCostoMedio(float costoMedio) {
        this.costoMedio = costoMedio;
    }

    public void setNumeroDiAbbonati(int numeroDiAbbonati) {
        this.numeroDiAbbonati = numeroDiAbbonati;
    }
}
