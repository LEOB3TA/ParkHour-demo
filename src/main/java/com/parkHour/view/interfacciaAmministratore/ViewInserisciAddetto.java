package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.BigController;
import com.parkHour.controller.gestioneAddetti.IGestioneAddetti;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ViewInserisciAddetto extends ViewWindow {
    private static IGestioneAddetti gestioneAddettiController;
    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private TextField codFisc;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public ViewInserisciAddetto() {
        gestioneAddettiController= BigController.getGestioneAddettiController();
    }

    @FXML
    protected void onAggiungiClick(){
        if(nome.getText().isEmpty()|| cognome.getText().isEmpty() || codFisc.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty()){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("nessun campo può essere vuoto");
            alert.show();
            return;
        }
        if(nome.getText().length()>20){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Nome troppo lungo, deve essere inferiore a 20 caratteri");
            alert.show();
            return;

        }
        if(cognome.getText().length()>20){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Cognome troppo lungo, deve essere inferiore a 20 caratteri");
            alert.show();
            return;
        }
        if(codFisc.getText().length()!=16){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("formato codice fiscale errato, deve essere di 16 caratteri");
            alert.show();
            return;
        }
        if(username.getText().length()>20){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Username troppo lungo, deve essere inferiore a 20 caratteri");
            alert.show();
            return;
        }
        if(password.getText().length()<8){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("La password deve essere di almeno 8 caratteri");
            alert.show();
            return;
        }else
        if(!password.getText().contains("ABCDEFGHILMNOPQRSTUVZYXKJW"))
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("La password deve contenere almeno una maiuscola");
            alert.show();
            return;
        }else
        if(!password.getText().contains("1234567890"))
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("La password deve contenere almeno un numero");
            alert.show();
            return;
        }else
        if(!password.getText().contains("@!#$%'-/=^_`{}~+"))
        {
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("La password deve contenere almeno un carattere speciale");
            alert.show();
            return;
        }

        if(gestioneAddettiController.aggiungiAddetto(nome.getText(),cognome.getText(),codFisc.getText(),username.getText(),password.getText())){
            nome.clear();cognome.clear();codFisc.clear();username.clear();password.clear();    Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("aggiunto addetto correttamente");
            alert.show();
        }else{
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile inserire un nuovo addetto");
            alert.show();
            return;
        }
    }
}
