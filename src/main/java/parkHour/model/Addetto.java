package parkHour.model;

public class Addetto {
    private String nome;
    private String cognome;
    private String codiceFiscale;
    private String numMatricola;
    private String username;
    private String passwordHash;

    public Addetto(String nome, String cognome, String codiceFiscale, String numMatricola, String username, String passwordHash) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.numMatricola = numMatricola;
        this.username = username;
        this.passwordHash = passwordHash;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
