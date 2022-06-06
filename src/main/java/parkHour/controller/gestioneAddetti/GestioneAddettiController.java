package parkHour.controller.gestioneAddetti;

import parkHour.model.Addetto;
import parkHour.model.Turno;

import java.time.LocalDateTime;
import java.util.List;

public class GestioneAddettiController implements IGestioneAddetti{
    private AggiungiAddettiController aggiungiAddettiController;
    private AggiungiTurnoController aggiungiTurnoController;
    private RimuoviTurnoController rimuoviTurnoController;
    private EliminaAddettiController eliminaAddettiController;
    private static List<Addetto>addetti;

    public GestioneAddettiController() {
    }

    public static boolean aggiungiAddetto(Addetto a){
       return addetti.add(a);
    }


    public static boolean rimuoviAddetto(Addetto a){
        return addetti.remove(a);
    }

    public boolean aggiungiTurno(Addetto addetto, LocalDateTime inizio,LocalDateTime fine){
        return aggiungiTurnoController.aggiungiTurno(addetto,inizio,fine);
    }
    public boolean rimuoviTurno(Addetto addetto,Turno toRemove){
        return rimuoviTurnoController.rimuoviTurno(addetto,toRemove);
    }

    public boolean aggiungiAddetto(String nome, String cognome,String codFisc,String username,String password){
        return aggiungiAddettiController.inserisciAddetto(nome,cognome,codFisc,username,password);
    }

    public boolean eliminaAddetto(Addetto toDelete){
        return eliminaAddettiController.eliminaAddetto(toDelete);
    }

    public static List<Addetto> getAddetti() {
        return addetti;
    }
}
