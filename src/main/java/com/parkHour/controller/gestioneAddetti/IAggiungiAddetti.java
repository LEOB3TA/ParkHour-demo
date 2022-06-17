package com.parkHour.controller.gestioneAddetti;

public interface IAggiungiAddetti {
    boolean inserisciAddetto(String nome, String cognome, String codFisc, String username, String password);
}
