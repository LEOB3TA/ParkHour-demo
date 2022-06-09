package com.parkHour.model;

public class Amministratore extends Addetto {
    public Amministratore(String nome, String cognome, String codiceFiscale, String numMatricola, String username, String passwordHash) {
        super(nome, cognome, codiceFiscale, numMatricola, username, passwordHash);
    }
}
