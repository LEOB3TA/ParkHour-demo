package com.parkHour.controller.gestioneSosta;

import com.parkHour.model.InfoTarga;
import com.parkHour.model.Sosta;

import java.util.ArrayList;
import java.util.List;

public interface IGestioneSosta {

      List<Sosta> sosteAttive=new ArrayList<>();
      List<Sosta> sosteConcluse=new ArrayList<>(); //simuliamo il db, non carichiamo nulla sul db ma su soste concluse

     boolean inputEntrata(InfoTarga infoTarga);
     boolean inputUscita(InfoTarga infoTarga);
     static List<Sosta> getSosteAttive() {
        return sosteAttive;
    }
}
