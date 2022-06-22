package com.parkHour.model;

import java.util.ArrayList;
import java.util.List;

public class Addetto {
    private final String nome;
    private final String cognome;
    private final String codiceFiscale;
    private final String numMatricola;
    private String username;
    private final String passwordHash;
    private final List<Turno> turni;

    public Addetto(String nome, String cognome, String codiceFiscale, String numMatricola, String username, String passwordHash) {
        this.nome = nome;
        this.cognome = cognome;
        this.codiceFiscale = codiceFiscale;
        this.numMatricola = numMatricola;
        this.username = username;
        this.passwordHash = passwordHash;
        this.turni=new ArrayList<>();
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean addTurno(Turno toAdd){
        for(Turno a:this.turni){
            if(a.getDataOrarioInizio().equals(toAdd.getDataOrarioInizio())){
                return false;
            }
        }
        return this.turni.add(toAdd);
    }

    public boolean removeTurno(Turno toRemove){
        return this.turni.remove(toRemove);
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public String getNumMatricola() {
        return numMatricola;
    }

    public String getUsername() {
        return username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public List<Turno> getTurni() {
        return turni;
    }

    @Override
    public String toString() {
        return "Addetto{" +
                "nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", codiceFiscale='" + codiceFiscale + '\'' +
                ", numMatricola='" + numMatricola + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
