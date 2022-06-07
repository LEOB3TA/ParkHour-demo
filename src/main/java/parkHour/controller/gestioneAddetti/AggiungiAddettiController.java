package parkHour.controller.gestioneAddetti;

import parkHour.model.Addetto;

public class AggiungiAddettiController implements IAggiungiAddetti{

    public AggiungiAddettiController() {
    }

    @Override
    public boolean inserisciAddetto(String nome, String cognome, String codFisc, String username, String password) {
        return GestioneAddettiController.aggiungiAddetto(new Addetto(nome,cognome,codFisc,calcolaNumeroMatricola(),username,password));
    }

    private String calcolaNumeroMatricola(){ // da implementare non so se sta qui o nel GestioneAddettiController
        return "Paolo_Ciaccia_king_of_the_world";
    }
}
