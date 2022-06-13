package com.parkHour.view.interfacciaVeicolo;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.controlsfx.control.table.TableRowExpanderColumn;

public class ViewUscita {
    @FXML
    private TextField targa;
    @FXML
    private TextField abbonamento;
    @FXML
    private TextField durataSosta;
    @FXML
    private TextField daPagare;
    @FXML
    private TextField versato;

    private float importoVersato;
    private float importoDaPagare;

    public ViewUscita() {
    }

    @FXML
    public void mostraValori(String targaV,boolean abbonamentoV,float minuti,float daPagareV){
        targa.setText(targaV);
        if(abbonamentoV){
            abbonamento.setText("Sì");
        }
        else {
            abbonamento.setText("No");
        }
        durataSosta.setText(minuti/60 + " ore "+ minuti%60+" minuti ");
        importoDaPagare=daPagareV;
        daPagare.setText(daPagareV+" €");
        versato.setText("0.00 €");
        this.importoVersato=0;
    }

    @FXML
    public void versa(float daVersare) throws InterruptedException {
        if(this.importoVersato+daVersare>this.importoDaPagare){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile pagare più del dovuto");
            alert.show();
            return;
        }
        importoVersato+=daVersare;
        versato.setText(importoVersato+" €");
        if(importoVersato==importoDaPagare){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("Grazie di aver utilizzato il parcheggio");
            alert.show();
            Thread.sleep(5000);
            targa.clear();
            abbonamento.clear();
            durataSosta.clear();
            daPagare.clear();
            versato.clear();
        }
    }

}
