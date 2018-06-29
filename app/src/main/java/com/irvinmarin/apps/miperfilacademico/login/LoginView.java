package com.irvinmarin.apps.miperfilacademico.login;


public interface LoginView {
    void enableImputs(boolean enable);

    void showMsj(String mensaje);

    void showProgress(String mensaje);

    void hidePorgress(String mensaje);

    void showMainActivity();

    void clearImputs();
}
