package com.parkHour.view.interfacciaAmministratore;

import com.parkHour.controller.gestioneAddetti.AggiungiAddettiController;
import com.parkHour.controller.gestioneAddetti.IAggiungiAddetti;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ViewInserisciAddetto extends ViewWindow {
    private static IAggiungiAddetti aggiungiAddettiController;
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
        aggiungiAddettiController = AggiungiAddettiController.getInstance();
    }

    @FXML
    protected void onAggiungiClick() {
        if (nome.getText().isEmpty() || cognome.getText().isEmpty() || codFisc.getText().isEmpty() || username.getText().isEmpty() || password.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
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
            alert.setContentText("formato codice fiscale errato, deve essere di esattamente 16 caratteri");
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
    alert.setContentText("Password troppo corta, deve essere di almeno 8 caratteri");
    alert.show();
    return;
}
int counterSpecial=0;
int counterUpper=0;
int counterNumber=0;
        for(int i=0;i< password.getText().length();i++){
            char c=password.getCharacters().charAt(i);
            if(Character.isUpperCase(c)){
                counterUpper++;
            }else if(Character.isDigit(c)){
                counterNumber++;
            }else if(c == '$' || c == '#' || c == '?' || c == '!' || c == '_' || c == '=' || c == '%'||c=='@'){
                counterSpecial++;
            }
        }
        if(counterNumber<1){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("La password deve contenere almeno un numero");
            alert.show();
            return;
        }
        if(counterSpecial<1){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("La password deve contenere almeno un carattere speciale");
            alert.show();
            return;
        }
        if(counterUpper<1){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setContentText("La password deve contenere almeno una lettera maiuscola");
            alert.show();
            return;
        }

        if (aggiungiAddettiController.inserisciAddetto(nome.getText(), cognome.getText(), codFisc.getText(), username.getText(), password.getText())) {
            nome.clear();
            cognome.clear();
            codFisc.clear();
            username.clear();
            password.clear();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setContentText("aggiunto addetto correttamente");
            alert.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("impossibile inserire un nuovo addetto");
            alert.show();
        }
    }
}
