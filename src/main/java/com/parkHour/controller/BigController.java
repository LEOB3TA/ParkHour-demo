package com.parkHour.controller;

import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.controller.login.LoginController;
import com.parkHour.model.Amministratore;

import java.util.List;

public class BigController {
    private static GestioneAddettiController gestioneAddettiController;
    private static LoginController loginController;

    public BigController() {
        this.gestioneAddettiController = new GestioneAddettiController();
        this.loginController=new LoginController();
    }

    public static GestioneAddettiController getGestioneAddettiController() {
        return gestioneAddettiController;
    }

    public static LoginController getLoginController() {
        return loginController;
    }
}
