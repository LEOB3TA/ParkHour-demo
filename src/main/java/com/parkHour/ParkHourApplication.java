package com.parkHour;

import com.parkHour.controller.BigController;
import com.parkHour.controller.IBigController;
import com.parkHour.controller.gestioneAbbonamenti.GestioneAbbonamentiController;
import com.parkHour.controller.gestioneAbbonamenti.IGestioneAbbonamenti;
import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.controller.gestioneAddetti.IGestioneAddetti;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class ParkHourApplication extends Application {

    public static Scene sceneLogin;
    public static Scene sceneEntrata;
    public static Scene sceneUscita;
    public static Scene sceneSimulazione;

    public static void main(String[] args) {
        IBigController bigController = BigController.getInstance();
        IGestioneAddetti gestioneAddetti= GestioneAddettiController.getInstance();
        IGestioneAbbonamenti gestioneAbbonamenti= GestioneAbbonamentiController.getInstance();
        launch();
    }

    @Override
    public void start(Stage stageLogin) throws IOException {
        Stage stateSimulazione=new Stage();
        Stage stateEntrata=new Stage();
        Stage stateUscita=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(ParkHourApplication.class.getResource("/parkHour.view.interfacciaAutenticazione/viewLogin.fxml"));
        sceneLogin = new Scene(fxmlLoader.load());
       fxmlLoader = new FXMLLoader(ParkHourApplication.class.getResource("/parkHour.view.interfacciaVeicolo/viewEntrata.fxml"));
        sceneEntrata = new Scene(fxmlLoader.load());
        BigController.setViewEntrata(fxmlLoader.getController());
        fxmlLoader = new FXMLLoader(ParkHourApplication.class.getResource("/parkHour.view.interfacciaVeicolo/viewUscita.fxml"));
        sceneUscita = new Scene(fxmlLoader.load());
        BigController.setViewUscita(fxmlLoader.getController());
        fxmlLoader = new FXMLLoader(ParkHourApplication.class.getResource("/parkHour.view.interfacciaSimulazione/viewSimulazione.fxml"));
        sceneSimulazione = new Scene(fxmlLoader.load());
        stageLogin.setTitle("Login");
        stageLogin.setScene(sceneLogin);
      stateEntrata.setTitle("CaselloEntrata");
        stateEntrata.setScene(sceneEntrata);
        stateUscita.setTitle("CaselloUscita");
        stateUscita.setScene(sceneUscita);
        stateSimulazione.setTitle("Simulazione");
        stateSimulazione.setScene(sceneSimulazione);
        stageLogin.show();
      stateEntrata.show();
        stateUscita.show();
        stateSimulazione.show();
    }


    public static void setRoot(AnchorPane pane, Parent parent) {
        pane.getChildren().clear();
        sceneLogin.setRoot(parent);
    }

}