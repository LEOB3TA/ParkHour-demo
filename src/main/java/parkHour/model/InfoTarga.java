package parkHour.model;

public class InfoTarga {
    private String targa;
    private boolean isAuto;
    private int cavalli;

    public InfoTarga(String targa, boolean isAuto, int cavalli) {
        this.targa = targa;
        this.isAuto = isAuto;
        this.cavalli = cavalli;
    }

    public String getTarga() {
        return targa;
    }

    public boolean isAuto() {
        return isAuto;
    }

    public int getCavalli() {
        return cavalli;
    }
}
