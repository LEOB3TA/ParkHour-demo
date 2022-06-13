package com.parkHour.controller.gestioneSosta;

import com.parkHour.model.InfoTarga;
import com.parkHour.model.Sosta;

import java.util.ArrayList;
import java.util.List;

public interface IGestioneSosta {



     boolean inputEntrata(InfoTarga infoTarga);
     boolean inputUscita(InfoTarga infoTarga);
}
