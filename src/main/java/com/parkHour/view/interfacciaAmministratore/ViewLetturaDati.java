package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.BigController;
import com.parkHour.controller.letturaDati.IStatistiche;
import com.parkHour.model.Sosta;
import com.parkHour.model.Statistiche;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ViewLetturaDati extends ViewWindow {
    private static IStatistiche statistiche;
    @FXML
    private ListView<String> elencoSoste;
    @FXML
    private TextField tempoMedio;
    @FXML
    private TextField costoMedio;
    @FXML
    private PieChart percentuali;

    public ViewLetturaDati() {
        BigController.calcolaAndSetstatistiche();
    }

    @Override
    protected void initialize() {
        statistiche = BigController.getStatisticheController();
        Statistiche statisticheS = statistiche.mostraStatistiche();
        System.out.println(elencoSoste);
        System.out.println(statisticheS.getSosteAttive());
        if (statisticheS.getSosteAttive() != null) {
            for (Sosta s:statisticheS.getSosteAttive()){
                elencoSoste.getItems().add(s.toString());
            }
        }
        tempoMedio.setText(String.valueOf(statisticheS.getTempoDiPermanenzaMedio()));
        costoMedio.setText(String.valueOf(statisticheS.getCostoMedio()));
        //continuare per inizializzare il grafico
    }
}
