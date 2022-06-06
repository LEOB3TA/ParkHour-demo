package parkHour.model;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Addetto {
    private final String nome;
    private final String cognome;
    private final String codiceFiscale;
    private final String numMatricola;
    private String username;
    private String passwordHash;
    private List<Turno> turni;

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

    public boolean addTurno(Turno toAdd){
        return this.turni.add(toAdd);
    }

    public boolean removeTurno(Turno toRemove){
        return this.turni.remove(toRemove);
    }
}
