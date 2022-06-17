package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.BigController;
import com.parkHour.controller.letturaDati.IStatistiche;
import com.parkHour.controller.letturaDati.StatisticheController;
import com.parkHour.model.Sosta;
import com.parkHour.model.Statistiche;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
        statistiche = StatisticheController.getInstance();
        Statistiche statisticheS = statistiche.mostraStatistiche();
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Standard", statisticheS.getNumeroStandard()),
                        new PieChart.Data("Premium", statisticheS.getNumeroPremium()),
                        new PieChart.Data("Green", statisticheS.getNumeroGreen()),
                        new PieChart.Data("Disabili", statisticheS.getNumeroDisabili()),
                        new PieChart.Data("Moto", statisticheS.getNumeroMoto()));
        if (statisticheS.getSosteAttive() != null) {
            for (Sosta s:statisticheS.getSosteAttive()){
                elencoSoste.getItems().add(s.toString());
            }
        }
        tempoMedio.setText(statisticheS.getTempoDiPermanenzaMedio()/60 +" ore "+statisticheS.getTempoDiPermanenzaMedio()%60 + " minuti");
        costoMedio.setText(statisticheS.getCostoMedio()+" €");
        percentuali.setData(pieChartData);
    }
}
