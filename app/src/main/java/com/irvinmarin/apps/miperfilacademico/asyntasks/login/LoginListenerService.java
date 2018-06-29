package com.irvinmarin.apps.miperfilacademico.asyntasks.login;

/**
 * Created by irvinmarin on 28/04/2017.
 */

public interface LoginListenerService {
    void loginCorrecto(String mensaje);

    void loginError(String mensaje);

    void loginErrorProcedimiento(String mensaje);
}
