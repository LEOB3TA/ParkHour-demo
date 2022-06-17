package com.parkHour.controller.login;

import com.parkHour.controller.gestioneAddetti.GestioneAddettiController;
import com.parkHour.model.Addetto;

public class LoginController implements ILogin{

    private static LoginController loginController=null;

    public static LoginController getInstance(){
        if (loginController == null) {
            loginController= new LoginController();
        }
        return loginController;
    }

    private LoginController() {
    }

    @Override
    public int login(String username, String password) {
        if(GestioneAddettiController.getAmministratore().getUsername().equals(username) && GestioneAddettiController.getAmministratore().getPasswordHash().equals(password)) {
            return 0;
        } else {
            for(Addetto a: GestioneAddettiController.getAddetti()){
                if(a.getUsername().equals(username) && a.getPasswordHash().equals(password)){
                    return 1;
                }
            }
        }
        return 2;
    }

    @Override
    public boolean logout() {
        return true;
    }
}
