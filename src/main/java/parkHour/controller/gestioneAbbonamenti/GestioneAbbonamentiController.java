package parkHour.controller.gestioneAbbonamenti;

import parkHour.model.Abbonamento;
import parkHour.model.TipologiaAbbonamento;
import parkHour.model.Veicolo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class GestioneAbbonamentiController implements IGestioneAbbonamenti {
    private AggiungiAbbonamentoController aggiungiAbbonamentoController;
    private RimuoviAbbonamentoController   rimuoviAbbonamentoController;
    private static List<Veicolo> veicoli=new ArrayList<Veicolo>();
    private static  List<Abbonamento> abbonamenti=new ArrayList<Abbonamento>();


    public GestioneAbbonamentiController(List<Veicolo> v){
        veicoli=v;
    }

    public static boolean aggiungiVeicolo(Veicolo v){
        return veicoli.add(v);
    }

    public static boolean rimuoviVeicolo(Veicolo veicolo){
        return veicoli.remove(veicolo);
    }


    public static List<Veicolo> getVeicoli(){
        return veicoli;
    }
public static boolean aggiungiAbbonamento(Abbonamento a){
       return abbonamenti.add(a);
}

    public  boolean aggiungiAbbonamento(String targa, TipologiaAbbonamento type, LocalDate data){
        return aggiungiAbbonamentoController.aggiungiAbbonamento(targa, type, data);
    }

    public static boolean rimuoviAbbonamento(Abbonamento a){
        return abbonamenti.remove(a);
    }

    public boolean eliminaAbbonamento(Abbonamento toRemove) {
        return rimuoviAbbonamentoController.rimuoviAbbonamento(toRemove);
    }


    public static List<Abbonamento> getAbbonamenti() {
return abbonamenti;
    }
}
