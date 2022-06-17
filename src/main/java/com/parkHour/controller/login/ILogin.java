package com.parkHour.controller.login;

public interface ILogin {
    int login(String username, String password);
    boolean logout();
}
