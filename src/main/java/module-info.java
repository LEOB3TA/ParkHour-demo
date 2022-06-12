module com.example.parkhourdemo {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
            
        requires org.controlsfx.controls;
            requires com.dlsc.formsfx;
            requires validatorfx;
            requires org.kordamp.ikonli.javafx;
            requires org.kordamp.bootstrapfx.core;
            requires eu.hansolo.tilesfx;
    
    opens com.example.parkhourdemo to javafx.fxml;
    exports com.example.parkhourdemo;
    opens com.parkHour to javafx.fxml;
    exports com.parkHour;
    opens com.parkHour.view.interfacciaAddetto to javafx.fxml;
    opens com.parkHour.view.interfacciaAmministratore to javafx.fxml;
    opens com.parkHour.view.interfacciaVeicolo to javafx.fxml;
    opens com.parkHour.view.interfacciaAutenticazione to javafx.fxml;
    opens com.parkHour.view.interfacciaSimulazione to javafx.fxml;
    exports com.parkHour.view.interfacciaAmministratore;
    exports com.parkHour.view.interfacciaAddetto;
    exports com.parkHour.view.interfacciaVeicolo;
}